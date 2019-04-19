package model;

import java.util.Collection;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Adresse {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	private String rue; 
	private final String ville = "Toulouse"; 
	private Collection<Etudiant> etudiants;
	public Adresse(String rue, Collection<Etudiant> etudiants) {
		super();
		this.rue = rue;
		this.etudiants = etudiants;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public Collection<Etudiant> getEtudiants() {
		return etudiants;
	}
	public void setEtudiants(Collection<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	public String getVille() {
		return ville;
	} 
	
	
	
}
