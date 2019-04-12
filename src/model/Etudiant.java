package model;

import java.util.Collection;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import enumerations.Niveau;

@Entity 
public class Etudiant {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	private String nom; 
	private String prenom; 
	private Adresse adresse; 
	private String mdp; 
	private Niveau niveau; 
	private int nbreSignal;
	private String email; 
	private String tel;
	private Collection<Troc> offreDeposee; 
	private Collection<Troc> offreDemandee;
	private Map<Creneau,Troc> historique; 
	
	
	public Etudiant(int id, String nom, String prenom, Adresse adresse, String mdp, Niveau niveau, int nbreSignal,String email) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.mdp = mdp;
		this.niveau = niveau;
		this.nbreSignal = nbreSignal;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public Niveau getNiveau() {
		return niveau;
	}
	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}
	public int getNbreSignal() {
		return nbreSignal;
	}
	public void setNbreSignal(int nbreSignal) {
		this.nbreSignal = nbreSignal;
	} 
	
	
	

	
	
}
