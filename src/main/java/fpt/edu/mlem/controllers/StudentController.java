package fpt.edu.mlem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fpt.edu.mlem.entities.Account;
import fpt.edu.mlem.entities.ListStudent;
import fpt.edu.mlem.services.AccountService;
import fpt.edu.mlem.services.ListStudentService;





public class StudentController {

	@Autowired
	private AccountService userService;
	@Autowired
	private ListStudentService studentService;

	
	@RequestMapping("Chapter/{id}")
	public String LessonPage(@PathVariable(name = "id") int id,@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie,
			Model model) {
		if(userCookie.equals("defaultCookieValue")) {
			
			
			model.addAttribute("user", null);
		} 
		else {
			Account user = userService.getAccount(userCookie);
			model.addAttribute("user", user);
			
			List<ListStudent> list = studentService.GetBotMail(user);
			
			for (ListStudent listStudent : list) {
				if(listStudent.getCourse().getId()==id) {
					return "Lesson";
					
				}
			}
			
		}
		
		return "redirect:/course_detail_view/"+id;	
	}
	
	@RequestMapping("/lesson")
	public String LessonPage(
			 int generalCourseId,
			 int chapterId,
			 int lessonId,
			@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie,
			Model model) {
		if(userCookie.equals("defaultCookieValue")) {
			
			
			model.addAttribute("user", null);
		} 
		else {
			Account user = userService.getAccount(userCookie);
			model.addAttribute("user", user);
			
			List<ListStudent> list = studentService.GetBotMail(user);
			
			for (ListStudent listStudent : list) {
				if(listStudent.getCourse().getId()==generalCourseId) {
					//model.addAttribute("lesson", l);
					System.out.print(listStudent);
					return "Lesson";
					
				}
			}
			
	
			
		}
		return "redirect:/course_detail_view/"+chapterId;	
	}
}
