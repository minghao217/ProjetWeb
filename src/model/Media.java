package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Media {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	private String url; 
	@ManyToOne
	private Troc troc; 
	private int type; //si type = 0 , c'est une image. si type = 1 => video
	
	
	
	public Media() {
		super();
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Troc getTroc() {
		return troc;
	}
	public void setTroc(Troc troc) {
		this.troc = troc;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
	
	
}
