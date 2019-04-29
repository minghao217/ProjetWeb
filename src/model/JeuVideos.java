package model;

import java.util.Collection;

import enumerations.Domaines;

// mjb : JeuVideo est un Domaine
public class JeuVideos extends Domaine {
	
	public JeuVideos(Domaines nom, String description, Collection<Troc> troc) {
		super(nom, description, troc);
		// TODO Auto-generated constructor stub
	}
	
	private String nomJeu;
	private int nbreJoueur;
	private String description;
	
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
