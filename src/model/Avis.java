package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import enumerations.Note;

@Entity
public class Avis {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
   private int id;
   private Etudiant beneficiaire;
   private Troc troc;
   private Note note; 
   private String Description;  
   
   
   
}
