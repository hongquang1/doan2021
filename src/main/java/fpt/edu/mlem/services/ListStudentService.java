package fpt.edu.mlem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.edu.mlem.entities.Account;
import fpt.edu.mlem.entities.ListStudent;
import fpt.edu.mlem.repositories.AccountRepository;
import fpt.edu.mlem.repositories.CourseRepository;
import fpt.edu.mlem.repositories.ListStudentRepository;

import java.util.List;

@Service
public class ListStudentService {
	@Autowired
	ListStudentRepository listStudentRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	CourseRepository generalCourseRepository;
	
	public ListStudent createListStudent(ListStudent listStudent) {
		return listStudentRepository.save(listStudent);
	}
	public List<ListStudent> GetBotMail(Account idStudent){
		return listStudentRepository.getCoursebyStudent(idStudent);
	}	
}
