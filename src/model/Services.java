package model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import enumerations.Domaines;
import enumerations.Etat;
import enumerations.TypeService;

// mjb : Service est un Domaine
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Services extends Troc {
	private TypeService type; 
	private boolean materielFourni;
	
   
   
   
public Services(Domaine domaine, Collection<Media> media, Etudiant proprio, int duree, Collection<Creneau> creneau,
			Etat etat, Collection<Avis> avis, TypeService type, boolean materielFourni) {
		super(domaine, media, proprio, duree, creneau, etat, avis);
		this.type = type;
		this.materielFourni = materielFourni;
	}
public TypeService getType() {
	return type;
}
public void setType(TypeService type) {
	this.type = type;
}
public boolean isMaterielFourni() {
	return materielFourni;
}
public void setMaterielFourni(boolean materielFourni) {
	this.materielFourni = materielFourni;
} 
   
   
     
}
