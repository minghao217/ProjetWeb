package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import enumerations.Etat;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Troc {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	@ManyToOne
	private Domaine domaine;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "troc")
	private Collection<Media> media = new ArrayList<Media>(); // photos ou
																// vidéos
	@ManyToOne
	private Etudiant proprio;

	// a ne pas utiliser
	private int duree; // duréee maximale du prête
	
	private String path ; 

	// private Collection<Creneau> creneau = new ArrayList<Creneau>();

	Date datedebut;
	Date datefin;
	private String etat;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "troc")
	private Collection<Avis> avis = new ArrayList<Avis>();

	// private Collection<Historique> historique;

	public Troc(Domaine domaine, Collection<Media> media, Etudiant proprio, int duree, ArrayList<Creneau> creneau,
			String etat2, Collection<Avis> avis) {
		super();
		this.domaine = domaine;
		this.media = media;
		this.proprio = proprio;
		this.duree = duree;
		// this.creneau = creneau;
		this.etat = etat2;
		this.avis = avis;
	}

	public Troc(String title, int duree, String etat) {
		super();
		this.title = title;
		this.duree = duree;
		this.etat = etat;
	}

	public Troc(String title, Date datedebut, Date datefin, String etat) {
		super();
		this.title = title;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.etat = etat;
	}

	public Troc(String title, Date datedebut, Date datefin, String etat, Etudiant et) {
		super();
		this.title = title;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.etat = etat;
		this.proprio = et;
	}

	public Troc() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Domaine getDomaine() {
		return domaine;
	}

	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}

	public Collection<Media> getMedia() {
		return media;
	}

	public void setMedia(Collection<Media> media) {
		this.media = media;
	}

	public Etudiant getProprio() {
		return proprio;
	}

	public void setProprio(Etudiant proprio) {
		this.proprio = proprio;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}
	// public Collection<Creneau> getCreneau() {
	// return creneau;
	// }
	// public void setCreneau(ArrayList<Creneau> creneau) {
	// this.creneau = creneau;
	// }

	public Collection<Avis> getAvis() {
		return avis;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public void setAvis(Collection<Avis> avis) {
		this.avis = avis;
	}

	public Date getDatedebut() {
		return datedebut;
	}

	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}

	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
