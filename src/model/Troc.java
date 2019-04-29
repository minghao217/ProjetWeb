package model;

import java.util.Collection;

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
public abstract class Troc {
	
	
   @Id 
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int id; 
   @ManyToOne
   private Domaine domaine; 
   @OneToMany(fetch = FetchType.EAGER,mappedBy="troc")
   private Collection<Media> media; // photos ou vidéos 
   @ManyToOne
   private Etudiant proprio; 
   private int duree; // duréee maximale du prête
   @OneToMany(fetch = FetchType.EAGER,mappedBy="troc")
   private Collection<Creneau> creneau; //la liste des disponibilités
   private Etat etat; 
   @OneToMany(fetch = FetchType.EAGER,mappedBy="troc")
   private Collection<Avis> avis;
   
   //private Collection<Historique> historique; 
   
   public Troc(Domaine domaine, Collection<Media> media, Etudiant proprio, int duree, Collection<Creneau> creneau,
			Etat etat, Collection<Avis> avis) {
		super();
		this.domaine = domaine;
		this.media = media;
		this.proprio = proprio;
		this.duree = duree;
		this.creneau = creneau;
		this.etat = etat;
		this.avis = avis;
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
public Collection<Creneau> getCreneau() {
	return creneau;
}
public void setCreneau(Collection<Creneau> creneau) {
	this.creneau = creneau;
}
public Etat getEtat() {
	return etat;
}
public void setEtat(Etat etat) {
	this.etat = etat;
}
public Collection<Avis> getAvis() {
	return avis;
}
public void setAvis(Collection<Avis> avis) {
	this.avis = avis;
}
   
   
   
   
   
}
