package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import enumerations.Niveau;

@Entity 
public class Etudiant {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	private String nom; 
	private String prenom;
	//Mjb : je suis pas trés convaincu par le faite qu'une adresse aie plusieurs Etudiants (Colocation)
	@ManyToOne
	private Adresse adresse; 
	
	private String mdp; 
	private Niveau niveau; 
	private int nbreSignal;
	private String email; 
	private String tel;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="beneficiaire")
	private Collection<Avis> comments = new ArrayList<>();
	@OneToMany(fetch = FetchType.EAGER,mappedBy="proprio")
	private Collection<Troc> offreDeposee = new ArrayList<>();; 
	// un Etudiant demande plusieurs Trocs
	// mjb  : je propose : private Troc offreDemandee + OneToOne 
	// càs un étudiant ne peut demander qu'un seul troc à la fois (juste pour faciliter avec optionItem)
	@OneToMany(fetch = FetchType.EAGER,mappedBy="proprio")
	private Collection<Troc> offreDemandee = new ArrayList<>();;
	// A ajouter une annotation si c'est nécessaire  
	//private HashMap<Creneau,Troc> historique = new HashMap<>(); 
	private String userName ; // nom + identifiant
	
	
	public Etudiant() {
		super();
	}



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
	
		

// Pour l'eregistrement
	public Etudiant(String nom, String prenom, String email, String tel) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tel = tel;
		
	}






	public Etudiant(String nom, String prenom, Adresse adresse, String mdp, Niveau niveau, int nbreSignal, String email,
			String tel, Collection<Avis> comments, Collection<Troc> offreDeposee, Collection<Troc> offreDemandee
			) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.mdp = mdp;
		this.niveau = niveau;
		this.nbreSignal = nbreSignal;
		this.email = email;
		this.tel = tel;
		this.comments = comments;
		this.offreDeposee = offreDeposee;
		this.offreDemandee = offreDemandee;
		//this.historique = historique;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public Collection<Avis> getComments() {
		return comments;
	}


	public void setComments(Collection<Avis> comments) {
		this.comments = comments;
	}


	public Collection<Troc> getOffreDeposee() {
		return offreDeposee;
	}


	public void setOffreDeposee(Collection<Troc> offreDeposee) {
		this.offreDeposee = offreDeposee;
	}


	public Collection<Troc> getOffreDemandee() {
		return offreDemandee;
	}


	public void setOffreDemandee(Collection<Troc> offreDemandee) {
		this.offreDemandee = offreDemandee;
	}


	

	
	
}
