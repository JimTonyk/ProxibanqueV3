package fr.proxibanque.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Cette classe abstraite factorise les caractéristiques d'un compte bancaire
 * Proxibanque (courant ou épargne).
 * 
 * @author Jean-Michel Hiltbrunner, Ozlem Avci
 *
 */

@Entity
public abstract class Compte {

	// *** ATTRIBUTES ***
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "groupe_idClient")
	private int idClient;
	private int numeroCompte;
	private double solde;
	private String dateOuverture;

	// *** CONSTRUCTORS ***

	public Compte() {
		super();
	}

	public Compte(int numeroCompte, double solde, String dateOuverture, int idClient) {
		super();
		this.numeroCompte = numeroCompte;
		this.solde = solde;
		this.dateOuverture = dateOuverture;
		this.idClient = idClient;
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

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	// *** OTHER METHODS ***

	@Override
	public String toString() {
		return "Compte [numeroCompte=" + numeroCompte + ", solde=" + solde + ", dateOuverture=" + dateOuverture
				+ ", idClient=" + idClient + "]";
	}

}
