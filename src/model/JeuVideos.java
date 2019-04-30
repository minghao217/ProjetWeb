package model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import enumerations.Domaines;
import enumerations.Etat;

// mjb : JeuVideo est un Domaine
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class JeuVideos extends Troc {
	
	private String nomJeu;
	private int nbreJoueur;
	private String description;
	
	
	
	
	
	public JeuVideos(Domaine domaine, Collection<Media> media, Etudiant proprio, int duree, Collection<Creneau> creneau,
			Etat etat, Collection<Avis> avis, String nomJeu, int nbreJoueur, String description) {
		super(domaine, media, proprio, duree, creneau, etat, avis);
		this.nomJeu = nomJeu;
		this.nbreJoueur = nbreJoueur;
		this.description = description;
	}
	public String getNomJeu() {
		return nomJeu;
	}
	public void setNom(String nomJeu) {
		this.nomJeu = nomJeu;
	}
	public int getNbreJoueur() {
		return nbreJoueur;
	}
	public void setNbreJoueur(int nbreJoueur) {
		this.nbreJoueur = nbreJoueur;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	

}
