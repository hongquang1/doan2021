package fpt.edu.mlem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fpt.edu.mlem.entities.Course;


@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
