package gapp.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import gapp.model.User;
import gapp.model.dao.DepartmentDao;
import gapp.model.dao.UserDao;
import gapp.web.validator.LoginValidator;
import gapp.web.validator.RegisterValidator;

@Controller
@SessionAttributes({ "department", "program", "addField" })
public class UserController {

	@Autowired
	private UserDao userDao;

	@Autowired
	private DepartmentDao departmentDao;

	@Autowired
	private RegisterValidator registerValidator;

	@Autowired
	private LoginValidator loginValidator;

	@RequestMapping(value = "/user/register.html", method = RequestMethod.GET)
	public String register(ModelMap models) {

		models.put("user", new User());
		return "user/register";
	}

	@RequestMapping(value = "/user/register.html", method = RequestMethod.POST)
	public String register(@ModelAttribute User user, ModelMap models, BindingResult result) {
		registerValidator.validate(user, result);
		if (result.hasErrors()) {
			return "user/register";
		} else {
			user = userDao.saveUser(user);
			return "redirect:/home.html";
		}

		/*
		 * if (userDao.isUserExists(user.getEmail().toLowerCase())) {
		 * models.put("message", "User with this email already exists"); return
		 * "user/register"; } else {
		 * user.setEmail(user.getEmail().toLowerCase()); user =
		 * userDao.saveUser(user); return "redirect:/home.html"; }
		 */

	}

	@RequestMapping(value = "/user/login.html", method = RequestMethod.GET)
	public String login(ModelMap models) {
		models.put("user", new User());
		return "user/login";
	}

	@RequestMapping(value = "/user/login.html", method = RequestMethod.POST)
	public String login(@ModelAttribute User user, ModelMap models, BindingResult result, HttpServletRequest request) {
		loginValidator.validate(user, result);
		if (result.hasErrors()) {
			return "user/login";
		} else {
			user = userDao.getUser(user.getEmail(), user.getPassword());
			if (user.getUserRoles().contains("ADMIN")) {
				request.getSession().setAttribute("userid", user.getId());
				return "redirect:/user/admin/adminPage.html";
			} else if (user.getUserRoles().contains("STAFF")) {
				return "redirect:/user/staff/staffPage.html";
			} else {
				request.getSession().setAttribute("userid", user.getId());
				return "redirect:/user/student/studentPage.html";
			}
		}
	}

	@RequestMapping(value = "/user/logout.html")
	public String logout(HttpSession session) {
		session.removeAttribute("userid");
		return "redirect:/home.html";
	}

	@RequestMapping(value = "/user/staff/staffPage.html")
	public String staffPage(ModelMap models) {
		return "user/staff/staffPage";
	}

	@RequestMapping(value = "/user/student/studentPage.html")
	public String studentPage(ModelMap models, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("userid") != null) {
			User user = userDao.getUser((Integer) session.getAttribute("userid"));
			models.put("user", user);
			return "user/student/studentPage";
		} else {
			return "redirect:/user/login.html";
		}
		
	}

	@RequestMapping(value = "/user/admin/adminPage.html")
	public String adminPage(ModelMap models, HttpSession session) {
		if(session.getAttribute("userid") != null) {
		models.put("departments", departmentDao.getDepartments());
		return "user/admin/adminPage";
		} else {
			return "redirect:/user/login.html";
		}
	}

}