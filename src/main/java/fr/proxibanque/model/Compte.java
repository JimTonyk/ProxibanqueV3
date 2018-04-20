package fr.proxibanque.model;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Cette classe abstraite factorise les caractéristiques d'un compte bancaire
 * Proxibanque (courant ou épargne).
 * 
 * @author Jean-Michel Hiltbrunner, Ozlem Avci
 *
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Compte {

	// *** ATTRIBUTES ***

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int numeroCompte;
	private double solde;
	private String dateOuverture;

	@ManyToOne(fetch=FetchType.EAGER, cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "client_idClient")
	private Client client;

	// *** CONSTRUCTORS ***

	public Compte() {
		super();
	}

	public Compte(int numeroCompte, double solde, String dateOuverture, Client client) {
		super();

		this.numeroCompte = numeroCompte;
		this.solde = solde;
		this.dateOuverture = dateOuverture;
		this.client = client;
	}

	// *** GETTERS and SETTERS ***

	public int getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(int numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public String getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(String dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	// *** OTHER METHODS ***

	@Override
	public String toString() {
		return "Compte [numeroCompte=" + numeroCompte + ", solde=" + solde + ", dateOuverture=" + dateOuverture
				+ ", client=" + client + "]";
	}

}