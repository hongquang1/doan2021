package fpt.edu.mlem.entities;




import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private int price;
	private int sale;
	private Date createDate;
	private String content;
	private String image;
	private String urlVideoCourse;
	private String urlYoutubeCourse;
	
	@ManyToOne
	private Level level;
	
	
	@ManyToMany
	private Set<Category> categories = new HashSet<Category>();
	
	@ManyToOne
	private Account manager;


	
	public void addRole(Category c) {
		this.categories.add(c);
	}
}
