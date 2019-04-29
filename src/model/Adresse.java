package model;

import java.util.Collection;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Adresse {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	private String rue; 
	private final String ville = "Toulouse"; 
	@OneToMany(fetch = FetchType.EAGER,mappedBy="adresse")
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
