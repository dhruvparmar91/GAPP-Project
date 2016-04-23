package gapp.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import gapp.model.AddField;
import gapp.model.AddValue;
import gapp.model.Application;
import gapp.model.Degree;
import gapp.model.dao.AddFieldDao;
import gapp.model.dao.AddValueDao;
import gapp.model.dao.AppStatusDao;
import gapp.model.dao.ApplicationDao;
import gapp.model.dao.DegreeDao;
import gapp.model.dao.DepartmentDao;
import gapp.model.dao.ProgramDao;
import gapp.model.dao.UserDao;

@Controller
@SessionAttributes("application")
public class EditApplicationController {

	@Autowired
	ApplicationDao applicationDao;

	@Autowired
	DepartmentDao departmentDao;

	@Autowired
	ProgramDao programDao;

	@Autowired
	UserDao userDao;

	@Autowired
	AppStatusDao appStatusDao;

	@Autowired
	DegreeDao degreeDao;

	@Autowired
	AddValueDao addValueDao;

	@Autowired
	AddFieldDao addFieldDao;

	@Autowired
	ServletContext context;

	@RequestMapping(value = "user/student/application/{appid}/editApplicationProgram.html", method = RequestMethod.GET)
	public String editApplicationProgram(@PathVariable Integer appid, ModelMap models, HttpSession session) {
		if (session.getAttribute("userid") != null) {
			Application application = applicationDao.getApplication(appid);
			models.put("application", application);
			models.put("programs", application.getDepartment().getPrograms());
			return "user/student/editApplicationProgram";
		} else {
			return "redirect:/user/login.html";
		}
	}

	@RequestMapping(value = "user/student/application/{appid}/editApplicationProgram.html", method = RequestMethod.POST)
	public String editApplicationProgram(@PathVariable Integer appid, @ModelAttribute Application application,
			ModelMap models, HttpSession session) {
		if (session.getAttribute("userid") != null) {
			application = applicationDao.saveApplication(application);
			models.put("application", application);
			return "redirect:/user/student/application/" + appid + ".html";
		} else {
			return "redirect:/user/login.html";
		}
	}

	@RequestMapping(value = "user/student/application/{appid}/editApplicantInfo.html", method = RequestMethod.GET)
	public String editApplicantInfo(@PathVariable Integer appid, @ModelAttribute Application application,
			ModelMap models, HttpSession session) {
		if (session.getAttribute("userid") != null) {
			models.put("application", application);
			return "user/student/editApplicantInfo";
		} else {
			return "redirect:/user/login.html";
		}
	}

	@RequestMapping(value = "user/student/application/{appid}/editApplicantInfo.html", method = RequestMethod.POST)
	public String editApplicantInfoPost(@PathVariable Integer appid, @ModelAttribute Application application,
			ModelMap models, HttpSession session) {
		if (session.getAttribute("userid") != null) {
			application = applicationDao.saveApplication(application);
			models.put("application", application);
			return "redirect:/user/student/application/" + appid + ".html";
		} else {
			return "redirect:/user/login.html";
		}
	}
	
	@RequestMapping(value = "user/student/application/{appid}/editAcademicInfo.html", method = RequestMethod.GET)
	public String editAcademicInfo(@PathVariable Integer appid, @ModelAttribute Application application,
			ModelMap models, HttpSession session) {
		if (session.getAttribute("userid") != null) {
			models.put("application", application);
			return "user/student/editAcademicInfo";
		} else {
			return "redirect:/user/login.html";
		}
	}
	
	@RequestMapping(value = "user/student/application/{appid}/editAcademicInfo.html", method = RequestMethod.POST)
	public String editAcademicInfoPost(@PathVariable Integer appid, @ModelAttribute Application application,
			ModelMap models, HttpSession session) {
		if (session.getAttribute("userid") != null) {
			application = applicationDao.saveApplication(application);
			models.put("application", application);
			return "redirect:/user/student/application/" + appid + ".html";
		} else {
			return "redirect:/user/login.html";
		}
	}
	
	@RequestMapping(value = "user/student/application/{appid}/editTranscriptUpload.html", method = RequestMethod.POST)
	public @ResponseBody String editTranscriptUpload(@PathVariable Integer appid, @ModelAttribute Application application,
			ModelMap models, @RequestParam("file") MultipartFile multipartFile,  HttpSession session) throws IllegalStateException, IOException {
		if (session.getAttribute("userid") != null) {
			Application app = applicationDao.getApplication(appid);
			File file = new File(multipartFile.getOriginalFilename());
			multipartFile.transferTo(file);
			app.setTranscript(file);
			app = applicationDao.saveApplication(app);
			models.put("application", app);
			return "Upload Successful !";
		} else {
			return "Session Expired ! Please login again to upload !";
		}
	}
	

	@RequestMapping(value = "user/student/application/{appid}/editEducationInfo.html", method = RequestMethod.GET)
	public String editEducationalInfo(@PathVariable Integer appid, @ModelAttribute Application application,
			ModelMap models, HttpSession session) {
		if (session.getAttribute("userid") != null) {
			models.put("application", application);
			models.put("degrees", application.getDegrees());
			return "user/student/EditEducationInfo";
		} else {
			return "redirect:/user/login.html";
		}
	}

	@RequestMapping(value = "user/student/application/{appid}/editEducationInfo.html", method = RequestMethod.POST)
	public String editEducationalInfoPost(@PathVariable Integer appid, @ModelAttribute Application application,
			ModelMap models, HttpSession session) {
		if (session.getAttribute("userid") != null) {
			application = applicationDao.saveApplication(application);
			models.put("application", application);
			return "redirect:/user/student/application/" + appid + ".html";
		} else {
			return "redirect:/user/login.html";
		}
	}

	@RequestMapping(value = "user/student/application/{appid}/addEducation.html", method = RequestMethod.GET)
	public String addEducation(@PathVariable Integer appid, ModelMap models, HttpSession session) {
		if (session.getAttribute("userid") != null) {
			Degree degree = new Degree();
			models.put("degree", degree);
			return "user/student/addEducation";
		} else {
			return "redirect:/user/login.html";
		}
	}

	@RequestMapping(value = "user/student/application/{appid}/addEducation.html", method = RequestMethod.POST)
	public String addEducationPost(@PathVariable Integer appid, ModelMap models, @ModelAttribute Degree degree,
			HttpSession session) {
		if (session.getAttribute("userid") != null) {
			Application application = applicationDao.getApplication(appid);
			degree.setApplication(application);
			degree = degreeDao.saveDegree(degree);
			models.put("application", applicationDao.getApplication(appid));
			models.put("degrees", applicationDao.getApplication(appid).getDegrees());
			return "redirect:editEducationInfo.html";
		} else {
			return "redirect:/user/login.html";
		}
	}

	@RequestMapping(value = "user/student/application/{appid}/editEducationInfo/{educationid}/editEducation.html", method = RequestMethod.GET)
	public String editEducation(@PathVariable Integer educationid, ModelMap models, HttpSession session) {
		if (session.getAttribute("userid") != null) {
			Degree degree = degreeDao.getDegree(educationid);
			models.put("degree", degree);
			return "user/student/editEducation";
		} else {
			return "redirect:/user/login.html";
		}
	}

	@RequestMapping(value = "user/student/application/{appid}/editEducationInfo/{educationid}/editEducation.html", method = RequestMethod.POST)
	public String editEducation(@PathVariable Integer educationid, @PathVariable Integer appid,
			@ModelAttribute Degree degree, ModelMap models, HttpSession session) {
		if (session.getAttribute("userid") != null) {
			Application application = applicationDao.getApplication(appid);
			degree.setId(educationid);
			degree.setApplication(application);
			degree = degreeDao.saveDegree(degree);
			models.put("application", applicationDao.getApplication(appid));
			models.put("degrees", applicationDao.getApplication(appid).getDegrees());
			return "redirect:/user/student/application/" + appid + "/editEducationInfo.html";
		} else {
			return "redirect:/user/login.html";
		}
	}

	@RequestMapping(value = "user/student/application/{appid}/editEducationInfo/{educationid}/removeEducation.html", method = RequestMethod.GET)
	public String removeEducation(@PathVariable Integer educationid, @PathVariable Integer appid,
			@ModelAttribute Degree degree, ModelMap models, HttpSession session) {
		if (session.getAttribute("userid") != null) {
			degreeDao.removeDegree(degreeDao.getDegree(educationid));
			models.put("application", applicationDao.getApplication(appid));
			models.put("degrees", applicationDao.getApplication(appid).getDegrees());
			return "redirect:/user/student/application/" + appid + "/editEducationInfo.html";
		} else {
			return "redirect:/user/login.html";
		}
	}

	@RequestMapping(value = "user/student/application/{appid}/editAdditionalInfo/{valueid}.html", method = RequestMethod.GET)
	public String AdditionalFields(@PathVariable Integer appid, @PathVariable Integer valueid, ModelMap models,
			HttpSession session) {
		if (session.getAttribute("userid") != null) {
			AddValue addValue = addValueDao.getAddValue(valueid);
			models.put("addvalue", addValue);

			return "user/student/editAddFields";
		} else {
			return "redirect:/user/login.html";
		}

	}

	@RequestMapping(value = "user/student/application/{appid}/editAdditionalInfo/{valueid}.html", method = RequestMethod.POST)
	public String AdditionalFields(@PathVariable Integer appid, @PathVariable Integer valueid,
			@ModelAttribute AddValue addvalue, SessionStatus status, HttpSession session) {
		if (session.getAttribute("userid") != null) {
			AddValue addValue = addValueDao.getAddValue(valueid);
			if (addValue.getAddField().getType().equals("number")) {
				addValue.setDoubleValue(addvalue.getDoubleValue());
			} else {
				addValue.setStringValue(addvalue.getStringValue());
			}
			addvalue = addValueDao.saveAddValue(addvalue);
			return "redirect:/user/student/application/" + appid + ".html";
		} else {
			return "redirect:/user/login.html";
		}

	}

	@RequestMapping(value = "user/student/application/{appid}/addFileUpload/{valueid}.html", method = RequestMethod.GET)
	public String uploadAdditionalFile(@PathVariable Integer appid, @PathVariable Integer valueid,
			@ModelAttribute Application application, ModelMap models, HttpSession session)
					throws IllegalStateException, IOException {
		if (session.getAttribute("userid") != null) {
			AddValue addValue = addValueDao.getAddValue(valueid);
			models.put("addvalue", addValue);

			return "user/student/editAddUploadFile";
		} else {
			return "redirect:/user/login.html";
		}
	}

	@RequestMapping(value = "user/student/application/{appid}/addFileUpload/{valueid}.html", method = RequestMethod.POST)
	public String uploadAdditionalFilePOST(@PathVariable Integer appid, @PathVariable Integer valueid,
			@ModelAttribute Application application, ModelMap models, @RequestParam("file") MultipartFile multipartFile,
			HttpSession session) throws IllegalStateException, IOException {
		if (session.getAttribute("userid") != null) {
			AddValue addValue = addValueDao.getAddValue(valueid);
			File file = new File(multipartFile.getOriginalFilename());
			multipartFile.transferTo(file);
			addValue.setFileValue(file);
			addValue = addValueDao.saveAddValue(addValue);

			return "redirect:/user/student/application/" + appid + ".html";
		} else {
			return "redirect:/user/login.html";
		}
	}
	
	@RequestMapping(value = "user/student/application/{appid}/editRequirements.html", method = RequestMethod.GET)
	public String editRequirements(@PathVariable Integer appid, @ModelAttribute Application application,
			ModelMap models, HttpSession session) {
		if (session.getAttribute("userid") != null) {
			Application app = applicationDao.getApplication(appid);
			List<AddField> addFields = app.getDepartment().getAddFields();
			if (app.getAddValues().size() == 0) {
				List<AddValue> addValues = new ArrayList<AddValue>();
				for (int i = 0; i < addFields.size(); i++) {
					AddValue addValue = new AddValue();
					addValue.setAddField(addFields.get(i));
					addValue.setApplication(app);
					addValue = addValueDao.saveAddValue(addValue);
					addValues.add(addValue);
				}
				app.setAddValues(addValues);
				app = applicationDao.saveApplication(app);
			}
			models.put("application", app);
			return "user/student/editRequirements";
		} else {
			return "redirect:/user/login.html";
		}
	}
	
	@RequestMapping(value = "user/student/application/{appid}/editRequirements.html", method = RequestMethod.POST)
	public String editRequirementsPost(@PathVariable Integer appid, @ModelAttribute Application application,
			ModelMap models, HttpSession session) {
		if (session.getAttribute("userid") != null) {
			Application app = applicationDao.getApplication(appid);

			for (int i = 0; i < app.getAddValues().size(); i++) {
				if (app.getAddValues().get(i).getAddField().getType().equals("number")
						|| app.getAddValues().get(i).getAddField().getType().equals("text")) {
					if (app.getAddValues().get(i).getAddField().getType().equals("number")) {
						app.getAddValues().get(i).setDoubleValue(application.getAddValues().get(i).getDoubleValue());
						addValueDao.saveAddValue(app.getAddValues().get(i));

					}
					if (app.getAddValues().get(i).getAddField().getType().equals("text")) {
						app.getAddValues().get(i).setStringValue(application.getAddValues().get(i).getStringValue());
						addValueDao.saveAddValue(app.getAddValues().get(i));
					}
				}
			}
			Application a = applicationDao.getApplication(appid);
			models.put("application", a);
			// app = applicationDao.saveApplication(app);
			return "redirect:/user/student/application/" + appid + ".html";
		} else {
			return "redirect:/user/login.html";
		}
	}
	
	@RequestMapping(value = "user/student/application/{appid}/uploadRequirement.html", method = RequestMethod.POST)
	public @ResponseBody String uploadRequirement(@PathVariable Integer appid,
			@ModelAttribute Application application, ModelMap models, @RequestParam("file") MultipartFile multipartFile,
			@RequestParam("field") Integer fieldId, HttpSession session) throws IllegalStateException, IOException {
		if (session.getAttribute("userid") != null) {
			Application app = applicationDao.getApplication(appid);
			AddField addField = addFieldDao.getAddField(fieldId);
			AddValue addValue = null;
			for (int i = 0; i < app.getAddValues().size(); i++) {
				if (app.getAddValues().get(i).getAddField().getId() == addField.getId()) {

					addValue = app.getAddValues().get(i);
				}
			}
			File file = new File(multipartFile.getOriginalFilename());
			multipartFile.transferTo(file);
			addValue.setFileValue(file);
			addValue = addValueDao.saveAddValue(addValue);
			Application a = applicationDao.getApplication(appid);
			models.put("application", a);
			return "Upload Succeessful !";
		} else {
			return "Session expired ! Please login to upload !";
		}
	}
	
}
