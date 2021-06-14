package fpt.edu.mlem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fpt.edu.mlem.entities.Account;
import fpt.edu.mlem.entities.ListStudent;


@Repository
public interface ListStudentRepository extends JpaRepository<ListStudent, Integer> {
	@Query("SELECT u FROM ListStudent u WHERE u.student = :student_id")
	public List<ListStudent> getCoursebyStudent(@Param("student_id") Account idStudent);

}
