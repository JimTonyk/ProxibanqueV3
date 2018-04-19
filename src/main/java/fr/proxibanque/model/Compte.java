package fr.proxibanque.model;

/**
 * Cette classe abstraite factorise les caractéristiques d'un compte bancaire
 * Proxibanque (courant ou épargne).
 * 
 * @author Jean-Michel Hiltbrunner, Ozlem Avci
 *
 */

public abstract class Compte {

	// *** ATTRIBUTES ***

	private int numeroCompte;
	private double solde;
	private String dateOuverture;
	private int idClient;

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
