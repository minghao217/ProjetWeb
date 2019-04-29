package model;

import javax.persistence.ManyToOne;

public class Creneau {
	@ManyToOne
	private Troc troc ; 
	private String debut; 
	private String fin;
	public Creneau(Troc troc, String debut, String fin) {
		super();
		this.troc = troc;
		this.debut = debut;
		this.fin = fin;
	}
	public Troc getTroc() {
		return troc;
	}
	public void setTroc(Troc troc) {
		this.troc = troc;
	}
	public String getDebut() {
		return debut;
	}
	public void setDebut(String debut) {
		this.debut = debut;
	}
	public String getFin() {
		return fin;
	}
	public void setFin(String fin) {
		this.fin = fin;
	} 
	
	
}
