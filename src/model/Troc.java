package model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import enumerations.Etat;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Troc {
	
	
   @Id 
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int id; 
   private Domaine domaine; 
   private Collection<Media> media; // photos ou vidéos 
   private Etudiant proprio; 
   private int duree; // duréee maximale du prête
   private Collection<Creneau> creneau; //la liste des disponibilités
   private Etat etat; 
   private Collection<Avis> avis;
   
   //private Collection<Historique> historique; 
   
   
   
}
