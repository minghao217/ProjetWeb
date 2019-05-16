package serverlet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import enumerations.Domaines;
import enumerations.Etat;
import model.Adresse;
import model.Creneau;
import model.Domaine;
import model.Etudiant;
import model.Troc;

@Singleton
public class Controller {
	
	 @PersistenceContext
	 private EntityManager em;
	 
	 /*on met à jour la bd des étudiants et des adresse*/
	 public void ajouterEtudiant(Etudiant etudiant, Adresse ad){
		 //ajouter l'etudiant à la bd
		 //ajouter l'adresse si elle n'existe pas
		 Adresse ad1 = ad; 
		 System.out.println(em);
		 TypedQuery<Adresse> req =  em.createQuery("select ad from Adresse ad " +"where ad.rue = '" + ad.getRue() + "'",Adresse.class);
		 List<Adresse> res = req.getResultList();
		 if (res.size() != 0){
			 ad1 = res.get(0);
		 }
		 else {
		    em.persist(ad1);
		 }
		 //ajouter l'etudiant
		 em.persist(etudiant);
		 //associer l'adreese a l'eudiant 
		 etudiant.setAdresse(ad); 		 
	 }
	 
	 public List<Etudiant> listerEtudiants(){
		 TypedQuery<Etudiant> req =  em.createQuery("select et from Etudiant et " ,Etudiant.class);
		 List<Etudiant> res = req.getResultList();
		 return res; 
		 
	 }
	 
	 public void ajouterAdresse(Adresse ad){
		 em.persist(ad);
	 }
	 
	 public void ajouterAdresse(String rue){
		 
	 }
	 
	 public Etudiant findByName(String name){
		 TypedQuery<Etudiant> req =  em.createQuery("select et from Etudiant et " + "where et.nom = '" + name + "'" ,Etudiant.class);
		 List<Etudiant> res = req.getResultList();
		 if (res.size()==0){
			 return null; 
		 }
		 else 
		  return res.get(0); 
	 }
	 
	 public void ajouterTroc(String titre,String duree,String etat,String domaine,Date datedeb , Date datefin) throws ParseException
	 {
//		int dureeReel = Integer.parseInt(duree);
		Etat etatReel = Etat.valueOf(etat);
//		Troc troc = new Troc(titre,dureeReel,etatReel) ;
		Date datedebut = datedeb ;
		Date datefiin =datefin;
		
		Troc troc = new Troc(titre,datedebut,datefiin,etatReel);
//		em.persist(troc);
		Domaines nomDom = Domaines.valueOf(domaine);
		// il faut que tu le récupére le domaine
		Domaine d = new Domaine(nomDom, domaine);
		em.persist(d);
		troc.setDomaine(d);
				
		em.persist(troc);
	 }
	
}
