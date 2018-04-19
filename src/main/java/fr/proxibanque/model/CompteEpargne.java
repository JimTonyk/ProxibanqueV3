package fr.proxibanque.model;

/**
 * Cette classe décrit les caractéristiques d'un compte épargne ProxiBanque.
 * Chaque client peut disposer d'un compte épargne après ajout explicite par un
 * conseiller. Aucune carte bancaire n'est associée à un compte épargne.
 * 
 * @author Jean-Michel Hiltbrunner, Ozlem Avci
 *
 */

public class CompteEpargne extends Compte {

	// *** ATTRIBUTES ***

	// TODO Le taux n'est pas utilisé dans ProxiBanqueSI
	private double tauxRemun = 3.0;

	// *** CONSTRUCTORS ***

	public CompteEpargne() {
		super();
	}

	public CompteEpargne(int numeroCompte, double solde, String dateOuverture) {
		super(numeroCompte, solde, dateOuverture);
	}

	// *** GETTERS and SETTERS ***

	public double getTauxRemun() {
		return tauxRemun;
	}

	public void setTauxRemun(double tauxRemun) {
		this.tauxRemun = tauxRemun;
	}

}
