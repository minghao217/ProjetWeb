package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import enumerations.Note;

@Entity
public class Avis {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
   private int id;
   @ManyToOne
   private Etudiant beneficiaire;
   @ManyToOne
   private Troc troc;
   private Note note; 
   private String Description;
   
   
   
public Avis() {
	super();
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Etudiant getBeneficiaire() {
	return beneficiaire;
}
public void setBeneficiaire(Etudiant beneficiaire) {
	this.beneficiaire = beneficiaire;
}
public Troc getTroc() {
	return troc;
}
public void setTroc(Troc troc) {
	this.troc = troc;
}
public Note getNote() {
	return note;
}
public void setNote(Note note) {
	this.note = note;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}  
   
   
   
}
