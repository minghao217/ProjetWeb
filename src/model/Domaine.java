package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import enumerations.Domaines;

@Entity
public class Domaine {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id; 
	private Domaines nom; 
	private String description ; 
	
}
