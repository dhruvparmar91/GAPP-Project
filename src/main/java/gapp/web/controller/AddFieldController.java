package gapp.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import gapp.model.AddField;
import gapp.model.Department;
import gapp.model.dao.AddFieldDao;
import gapp.model.dao.DepartmentDao;

@Controller
@SessionAttributes({ "department", "program", "addField" })
public class AddFieldController {

	@Autowired
	private DepartmentDao departmentDao;

	@Autowired
	private AddFieldDao addFieldDao;

	@RequestMapping(value = "/user/admin/department/{id}/addField.html", method = RequestMethod.GET)
	public String addField(@PathVariable Integer id, ModelMap models, HttpSession session) {
		if (session.getAttribute("userid") != null) {
			Department department = departmentDao.getDepartment(id);
			AddField addField = new AddField();
			models.put("department", department);
			models.put("addField", addField);
			return "user/admin/addField";
		} else {
			return "redirect:/user/login.html";
		}
	}

	@RequestMapping(value = "/user/admin/department/{id}/addField.html", method = RequestMethod.POST)
	public String addField(@PathVariable Integer id, @ModelAttribute AddField addField,
			@ModelAttribute Department department, ModelMap models, HttpSession session) {
		if (session.getAttribute("userid") != null) {
			addField.setDepartment(department);
			addField = addFieldDao.saveAdditional(addField);
			return "redirect:/user/admin/adminPage.html";
		} else {
			return "redirect:/user/login.html";
		}
	}

	@RequestMapping(value = "/user/admin/department/{id}/editField/{editid}.html", method = RequestMethod.GET)
	public String editField(@PathVariable Integer id, @PathVariable Integer editid, ModelMap models,
			HttpSession session) {
		if (session.getAttribute("userid") != null) {
			models.put("addField", addFieldDao.getAddField(editid));
			return "/user/admin/EditField";
		} else {
			return "redirect:/user/login.html";
		}
	}

	@RequestMapping(value = "/user/admin/department/{id}/editField/{editid}.html", method = RequestMethod.POST)
	public String editField(@PathVariable Integer id, @PathVariable Integer editid, @ModelAttribute AddField addField,
			SessionStatus status, HttpSession session) {
		if (session.getAttribute("userid") != null) {
			addField.setId(editid);
			addField = addFieldDao.saveAdditional(addField);
			Integer argid = addField.getDepartment().getId();
			status.setComplete();
			return "redirect:/user/admin/department/" + argid + ".html";
		} else {
			return "redirect:/user/login.html";
		}
	}

	@RequestMapping(value = "/user/admin/department/{id}/removeField/{removeid}.html", method = RequestMethod.GET)
	public String removeField(@PathVariable Integer id, @PathVariable Integer removeid, ModelMap models,
			HttpSession session) {
		if (session.getAttribute("userid") != null) {
			addFieldDao.removeField(addFieldDao.getAddField(removeid));
			return "redirect:/user/admin/department/" + id + ".html";

		} else {
			return "redirect:/user/login.html";
		}
	}
}
