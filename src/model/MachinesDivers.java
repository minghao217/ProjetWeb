package model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;

import enumerations.Etat;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class MachinesDivers extends Troc{
    private String nom; 
    private String description;
    
    
	

	public MachinesDivers(Domaine domaine, Collection<Media> media, Etudiant proprio, int duree,
			ArrayList<Creneau> creneau, Etat etat, Collection<Avis> avis, String nom, String description) {
		super(domaine, media, proprio, duree, creneau, etat, avis);
		this.nom = nom;
		this.description = description;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	} 
    
}
