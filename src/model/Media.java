package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Media {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	private String url; 
	private Troc troc; 
	private int type; //si type = 0 , c'est une image. si type = 1 => video
	
	
}
