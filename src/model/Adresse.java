package model;

import java.util.ArrayList;
import java.util.Collection;


import javax.persistence.Entity;

import javax.persistence.FetchType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Adresse {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	private String rue; 
	private final String ville = "Toulouse"; 
	@OneToMany(fetch = FetchType.EAGER,mappedBy="adresse")
	private Collection<Etudiant> etudiants = new ArrayList<>();;
	
	
	public Adresse(String rue) {
		super();
		this.rue = rue;
	}

	public Adresse() {
		super();
	}

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
