package fpt.edu.mlem.entities;
 

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lesson {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	private String title;	
	private String urlVideo;	
	private String urlFile;	
	private String des_lesson;	
	private Date date_lesson;	
	
	
	@ManyToOne
	private Chapter chapter;
	
	
	
}
