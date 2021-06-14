package fpt.edu.mlem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fpt.edu.mlem.entities.Chapter;


@Repository
public interface ChapterRepository extends JpaRepository<Chapter, Integer> {

}
