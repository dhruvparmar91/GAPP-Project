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
import gapp.model.Program;
import gapp.model.dao.AddFieldDao;
import gapp.model.dao.DepartmentDao;
import gapp.model.dao.ProgramDao;

@Controller
@SessionAttributes({ "department", "program", "addField" })
public class DepartmentController {

	@Autowired
	private DepartmentDao departmentDao;

	@Autowired
	private ProgramDao programDao;

	@Autowired
	private AddFieldDao addFieldDao;

	@RequestMapping(value = "/user/admin/department/{id}.html")
	public String viewDepartment(@PathVariable Integer id, ModelMap models, HttpSession session) {
		if (session.getAttribute("userid") != null) {
			models.put("department", departmentDao.getDepartment(id));

			return "user/admin/viewDepartment";
		} else {
			return "redirect:/user/login.html";
		}
	}

	@RequestMapping(value = "/user/admin/addDepartment.html", method = RequestMethod.GET)
	public String addDepartment(ModelMap models, HttpSession session) {
		if (session.getAttribute("userid") != null) {
			models.put("department", new Department());
			return "user/admin/addDepartment";
		} else {
			return "redirect:/user/login.html";
		}
	}

	@RequestMapping(value = "/user/admin/addDepartment.html", method = RequestMethod.POST)
	public String addDepartment(@ModelAttribute Department department, ModelMap models, HttpSession session) {
		if (session.getAttribute("userid") != null) {
			department = departmentDao.saveDepartment(department);
			return "redirect:/user/admin/adminPage.html";
		} else {
			return "redirect:/user/login.html";
		}
	}

	@RequestMapping(value = "/user/admin/department/{id}/removeDepartment.html", method = RequestMethod.GET)
	public String removeDepartment(@PathVariable Integer id, ModelMap models, HttpSession session) {
		if (session.getAttribute("userid") != null) {
			Department d = departmentDao.getDepartment(id);
			for (Program p : d.getPrograms()) {
				programDao.removeProgram(p);
			}
			for (AddField a : d.getAddFields()) {
				addFieldDao.removeField(a);
			}
			departmentDao.removeDepartment(d);
			return "redirect:/user/admin/adminPage.html";
		} else {
			return "redirect:/user/login.html";
		}
	}

	@RequestMapping(value = "/user/admin/department/{id}/editName.html", method = RequestMethod.GET)
	public String editName(@PathVariable Integer id, ModelMap models, HttpSession session) {
		if (session.getAttribute("userid") != null) {
			models.put("department", departmentDao.getDepartment(id));
			return "/user/admin/EditDepartmentName";
		} else {
			return "redirect:/user/login.html";
		}
	}

	@RequestMapping(value = "/user/admin/department/{id}/editName.html", method = RequestMethod.POST)
	public String editName(@PathVariable Integer id, @ModelAttribute Department department, SessionStatus status,
			HttpSession session) {
		if (session.getAttribute("userid") != null) {
			department = departmentDao.saveDepartment(department);
			Integer argid = department.getId();
			status.setComplete();
			return "redirect:/user/admin/department/" + argid + ".html";
		} else {
			return "redirect:/user/login.html";
		}
	}
}
