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

import gapp.model.Department;
import gapp.model.Program;
import gapp.model.dao.DepartmentDao;
import gapp.model.dao.ProgramDao;

@Controller
@SessionAttributes({ "department", "program", "addField" })
public class ProgramController {

	@Autowired
	private DepartmentDao departmentDao;

	@Autowired
	private ProgramDao programDao;

	@RequestMapping(value = "/user/admin/department/{id}/addProgram.html", method = RequestMethod.GET)
	public String addProgram(@PathVariable Integer id, ModelMap models, HttpSession session) {
		if (session.getAttribute("userid") != null) {
			Department department = departmentDao.getDepartment(id);
			Program program = new Program();
			// program.setDepartment(department);
			models.put("department", department);
			models.put("program", program);
			return "user/admin/addProgram";
		} else {
			return "redirect:/user/login.html";
		}
	}

	@RequestMapping(value = "/user/admin/department/{id}/addProgram.html", method = RequestMethod.POST)
	public String addProgram(@PathVariable Integer id, @ModelAttribute Program program,
			@ModelAttribute Department department, ModelMap models, HttpSession session) {
		if (session.getAttribute("userid") != null) {
			program.setDepartment(department);
			program = programDao.saveProgram(program);
			// department = program.getDepartment();
			// department.addProgram(program);
			return "redirect:/user/admin/adminPage.html";
		} else {
			return "redirect:/user/login.html";
		}
	}

	@RequestMapping(value = "/user/admin/department/{id}/editProgram/{editid}.html", method = RequestMethod.GET)
	public String editProgram(@PathVariable Integer id, @PathVariable Integer editid, ModelMap models,
			HttpSession session) {
		if (session.getAttribute("userid") != null) {
			models.put("program", programDao.getProgram(editid));
			return "/user/admin/EditProgram";
		} else {
			return "redirect:/user/login.html";
		}
	}

	@RequestMapping(value = "/user/admin/department/{id}/editProgram/{editid}.html", method = RequestMethod.POST)
	public String editProgram(@PathVariable Integer id, @PathVariable Integer editid, @ModelAttribute Program program,
			SessionStatus status, HttpSession session) {
		if (session.getAttribute("userid") != null) {
			program.setId(editid);
			program = programDao.saveProgram(program);
			Integer argid = program.getDepartment().getId();
			status.setComplete();
			return "redirect:/user/admin/department/" + argid + ".html";
		} else {
			return "redirect:/user/login.html";
		}
	}

	@RequestMapping(value = "/user/admin/department/{id}/removeProgram/{removeid}.html", method = RequestMethod.GET)
	public String removeProgram(@PathVariable Integer id, @PathVariable Integer removeid, ModelMap models,
			HttpSession session) {
		if (session.getAttribute("userid") != null) {
			programDao.removeProgram(programDao.getProgram(removeid));
			return "redirect:/user/admin/department/" + id + ".html";
		} else {
			return "redirect:/user/login.html";
		}
	}

}
