package model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Domaine {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nom;
	private String description;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "domaine")
	private Collection<Troc> troc;

	public Domaine(String nom, String description, Collection<Troc> troc) {
		super();
		this.nom = nom;
		this.description = description;
		this.troc = troc;
	}

	public Domaine(String nom, String description) {
		super();
		this.nom = nom;
		this.description = description;
	}

	public Domaine() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Collection<Troc> getTroc() {
		return troc;
	}

	public void setTroc(Collection<Troc> troc) {
		this.troc = troc;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
