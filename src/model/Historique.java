package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Historique implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// relations unidirectionnelles
	@ManyToOne(fetch = FetchType.EAGER)
	private Troc troc;

	@ManyToOne(fetch = FetchType.EAGER)
	private Etudiant beneficiaire;
	@ManyToOne(fetch = FetchType.EAGER)
	private Etudiant proprio;
	private Date datedebut;
	private Date datefin;
	private boolean etatDeroulement;
	private String description;

	public Historique() {
		super();
	}
	
	

	public Historique(Troc troc, Etudiant beneficiaire, Etudiant proprio, Date datedebut, Date datefin) {
		super();
		this.troc = troc;
		this.beneficiaire = beneficiaire;
		this.proprio = proprio;
		this.datedebut = datedebut;
		this.datefin = datefin;
	}



	public Troc getTroc() {
		return troc;
	}

	public void setTroc(Troc troc) {
		this.troc = troc;
	}

	public Etudiant getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(Etudiant beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

	public Etudiant getProprio() {
		return proprio;
	}

	public void setProprio(Etudiant proprio) {
		this.proprio = proprio;
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

	public boolean isEtatDeroulement() {
		return etatDeroulement;
	}

	public void setEtatDeroulement(boolean etatDeroulement) {
		this.etatDeroulement = etatDeroulement;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
