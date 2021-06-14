package fpt.edu.mlem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fpt.edu.mlem.entities.Account;
import fpt.edu.mlem.entities.Course;
import fpt.edu.mlem.entities.ListStudent;
import fpt.edu.mlem.services.AccountService;
import fpt.edu.mlem.services.CourseService;
import fpt.edu.mlem.services.ListStudentService;

@Controller
public class PublicController {

	@RequestMapping("/")
	public String Home(@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie,
			Model model) {
		if(userCookie.equals("defaultCookieValue")) {	
			model.addAttribute("user", null);
			System.out.print("defaultCookieValue");
		} 
		else {
			Account user = userService.getAccount(userCookie);
	
			model.addAttribute("user", user);
			System.out.print(user);
			List<ListStudent> listStudent = studentService.GetBotMail(user);
			model.addAttribute("listStudent", listStudent);
		}
		
	 return "index";
	}
	
	@RequestMapping("listcourse")
	public String Listcourse(@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie,
			Model model) {
		if(userCookie.equals("defaultCookieValue")) {
			
			
			model.addAttribute("user", null);
		} 
		else {
			Page<Course> list = generalCourseService.getGeneralCoursePage(0, 8);
				
		        model.addAttribute("list", list);
		      
			Account user = accountService.getAccount(userCookie);
			model.addAttribute("user", user);
			
	}
		return "listcourse";

	}

	@RequestMapping("course_detail_view/{id}")
	public String Course_detail_view(@PathVariable(name = "id") int id,@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie,
			Model model) {
		if(userCookie.equals("defaultCookieValue")) {
			
			
			model.addAttribute("user", null);
		} 
		else {
			Account user = userService.getAccount(userCookie);
		
			model.addAttribute("user", user);
			Course generalC = generalCourseService.findGeneralCourseById(id);
			model.addAttribute("generalC", generalC);
			List<ListStudent> list = studentService.GetBotMail(user);
			boolean check = false;
			for (ListStudent listStudent : list) {
				if(listStudent.getCourse().getId()==generalC.getId()) {
					check=true;
					
					break;
				}
			}
			model.addAttribute("check", check);
		}
			
		return "course_detail_view";
	}

	@RequestMapping("MyCourse")
	public String MyCourse(@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie,
			Model model) {
		if(userCookie.equals("defaultCookieValue")) {
			
			
			model.addAttribute("user", null);
		} 
		else {
			Account user = userService.getAccount(userCookie);
		
			model.addAttribute("user", user);
			List<ListStudent> list = studentService.GetBotMail(user);
			model.addAttribute("list", list);
		}
			
		return "KhoaHocCuaToi";
	}
	@Autowired
	private AccountService userService;
	@Autowired
	private ListStudentService studentService;
	@Autowired
	private CourseService generalCourseService;
	@Autowired
	AccountService accountService;
	
}
