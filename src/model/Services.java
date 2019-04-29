package model;

import java.util.Collection;

import enumerations.Domaines;
import enumerations.TypeService;

// mjb : Service est un Domaine
public class Services extends Domaine {
   public Services(Domaines nom, String description, Collection<Troc> troc) {
		super(nom, description, troc);
		// TODO Auto-generated constructor stub
	}
   
private TypeService type; 
   private boolean materielFourni;
   
   
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
