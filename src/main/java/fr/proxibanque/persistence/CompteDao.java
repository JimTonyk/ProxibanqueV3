package fr.proxibanque.persistence;

import fr.proxibanque.model.CompteCourant;
import fr.proxibanque.model.CompteEpargne;

/**
 * Cette méthode permet de réaliser les opérations du CRUD sur la base de
 * données MySQL pour les comptes courant et les comptes épargne associés
 * 
 * @author Jean-Michel Hiltbrunner et Ozlem Avci
 *
 */
public interface CompteDao {

	/**
	 * Cette méthode permet d'ajouter un compte courant à la base de données
	 * 
	 * @param compteCourant
	 *            Compte que l'on souhaite persister dans la base de données
	 */
	void creerCompteCourant(CompteCourant compteCourant);

	/**
	 * Cette méthode permet d'ajouter un compte épargne à la base de données
	 * 
	 * @param compteEpargne
	 *            Compte que l'on souhaite persister dans la base de données
	 */
	void creerCompteEpargne(CompteEpargne compteEpargne);

	/**
	 * Cette méthode permet de récuperer les informations relatives à un compte
	 * Courant (date d'ouverture, solde, détenteur) connaissant son numéro
	 * d'identification unique
	 * 
	 * @param idClient
	 *            numéro d'identification du client associé du compte courant
	 * @return Compte courant associé au numéro d'identification
	 */
	CompteCourant obtenirCompteCourant(int idClient);

	/**
	 * Cette méthode permet de récupérer les informations relatives à un compte
	 * épargne (date d'ouverture, solde, taux d'intéret, détenteur) connaissant son
	 * numéro
	 * 
	 * @param idClient
	 *            numéro d'identification du client associé au compte épargne
	 * @return Compte épargne lié au numéro donnée en argument
	 */
	CompteEpargne obtenirCompteEpargne(int idClient);

	/**
	 * Cette méthode permet de modifier les informations sur un compte courant
	 * notamment si un client dépose des espèce ou un chèque sur son compte
	 * 
	 * @param idClient
	 *            Identifiant du client dont on souahite modifier le compte
	 */
	void modifierCompteCourant(int idClient);

	/**
	 * Cette méthode permet de modifier les informations sur un compte épargne,
	 * notamment si le client qui le possède dépose de l'argent ou effectue un
	 * retrait dans une agence Proxibanque
	 * 
	 * @param idClient
	 *            Numéro d'identification du client dont on souhaite modifier les
	 *            données sur le compte épargne
	 */
	void modifierCompteEpargne(int idClient);

	/**
	 * Cette méthode supprime un compte courant de la base de données Proxibanque.
	 * Attention, sa suppression entraîne la suppression du client qui détient le
	 * compte !
	 * 
	 * @param compteCourant
	 *            Compte courant dont on souhaite réaliser la suppression du compte.
	 */
	void supprimerCompteCourant(CompteCourant compteCourant);

	/**
	 * Cette méthode permet de supprimer un compte épargne de la base de données
	 * Proxibanque. Attention, sa suppression entraîne la suppression du client qui
	 * détient le compte !
	 * 
	 * @param compteEpargne
	 *            Compte épargne dont on souhaite réaliser la suppression
	 */
	void supprimerCompteEpargne(CompteEpargne compteEpargne);
}
