package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Historique {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	
    private Troc troc; 
    private Etudiant beneficiaire; 
    private Etudiant proprio; 
    private Creneau creneau; 
    private boolean etatDeroulement; 
    private String description; 
    
}
