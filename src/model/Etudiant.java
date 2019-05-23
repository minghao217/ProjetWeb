package model;

import java.io.Serializable;
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
public class Etudiant implements Serializable {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	private String nom; 
	private String prenom;
	//Mjb : je suis pas trés convaincu par le faite qu'une adresse aie plusieurs Etudiants (Colocation)
	@ManyToOne
	private Adresse adresse; 
	private String gender; 
	
	private String mdp; 
	private Niveau niveau; 
	private int nbreSignal;
	private String email; 
	private String tel;
	private String level; 
	private String path; 
	
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
	
		

public String getLevel() {
		return level;
	}



	public String getGender() {
	return gender;
}



public void setGender(String gender) {
	this.gender = gender;
}



	public void setLevel(String level) {
		this.level = level;
	}



	// Pour l'eregistrement
	public Etudiant(String nom, String prenom, String email, String tel ,String path) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tel = tel;
		this.path = "./images/"+path;
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

	public String getpath() {
		return this.path;
	}


	public void setpath(String path) {
		this.path = path;
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



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((mdp == null) ? 0 : mdp.hashCode());
		result = prime * result + nbreSignal;
		result = prime * result + ((niveau == null) ? 0 : niveau.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((offreDemandee == null) ? 0 : offreDemandee.hashCode());
		result = prime * result + ((offreDeposee == null) ? 0 : offreDeposee.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Etudiant other = (Etudiant) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (mdp == null) {
			if (other.mdp != null)
				return false;
		} else if (!mdp.equals(other.mdp))
			return false;
		if (nbreSignal != other.nbreSignal)
			return false;
		if (niveau != other.niveau)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (offreDemandee == null) {
			if (other.offreDemandee != null)
				return false;
		} else if (!offreDemandee.equals(other.offreDemandee))
			return false;
		if (offreDeposee == null) {
			if (other.offreDeposee != null)
				return false;
		} else if (!offreDeposee.equals(other.offreDeposee))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}


	

	
	
}
