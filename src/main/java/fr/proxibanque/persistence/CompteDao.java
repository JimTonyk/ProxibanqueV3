package fr.proxibanque.persistence;

import fr.proxibanque.model.CompteCourant;
import fr.proxibanque.model.CompteEpargne;

/**
 * Cette m�thode permet de r�aliser les op�rations du CRUD sur la base de
 * donn�es MySQL pour les comptes courant et les comptes �pargne associ�s
 * 
 * @author Jean-Michel Hiltbrunner et Ozlem Avci
 *
 */
public interface CompteDao {

	/**
	 * Cette m�thode permet d'ajouter un compte courant � la base de donn�es
	 * 
	 * @param compteCourant
	 *            Compte que l'on souhaite persister dans la base de donn�es
	 */
	void creerCompteCourant(CompteCourant compteCourant);

	/**
	 * Cette m�thode permet d'ajouter un compte �pargne � la base de donn�es
	 * 
	 * @param compteEpargne
	 *            Compte que l'on souhaite persister dans la base de donn�es
	 */
	void creerCompteEpargne(CompteEpargne compteEpargne);

	/**
	 * Cette m�thode permet de r�cuperer les informations relatives � un compte
	 * Courant (date d'ouverture, solde, d�tenteur) connaissant son num�ro
	 * d'identification unique
	 * 
	 * @param idClient
	 *            num�ro d'identification du client associ� du compte courant
	 * @return Compte courant associ� au num�ro d'identification
	 */
	CompteCourant obtenirCompteCourant(int idClient);

	/**
	 * Cette m�thode permet de r�cup�rer les informations relatives � un compte
	 * �pargne (date d'ouverture, solde, taux d'int�ret, d�tenteur) connaissant son
	 * num�ro
	 * 
	 * @param idClient
	 *            num�ro d'identification du client associ� au compte �pargne
	 * @return Compte �pargne li� au num�ro donn�e en argument
	 */
	CompteEpargne obtenirCompteEpargne(int idClient);

	/**
	 * Cette m�thode permet de modifier les informations sur un compte courant
	 * notamment si un client d�pose des esp�ce ou un ch�que sur son compte
	 * 
	 * @param idClient
	 *            Identifiant du client dont on souahite modifier le compte
	 */
	void modifierCompteCourant(int idClient);

	/**
	 * Cette m�thode permet de modifier les informations sur un compte �pargne,
	 * notamment si le client qui le poss�de d�pose de l'argent ou effectue un
	 * retrait dans une agence Proxibanque
	 * 
	 * @param idClient
	 *            Num�ro d'identification du client dont on souhaite modifier les
	 *            donn�es sur le compte �pargne
	 */
	void modifierCompteEpargne(int idClient);

	/**
	 * Cette m�thode supprime un compte courant de la base de donn�es Proxibanque.
	 * Attention, sa suppression entra�ne la suppression du client qui d�tient le
	 * compte !
	 * 
	 * @param compteCourant
	 *            Compte courant dont on souhaite r�aliser la suppression du compte.
	 */
	void supprimerCompteCourant(CompteCourant compteCourant);

	/**
	 * Cette m�thode permet de supprimer un compte �pargne de la base de donn�es
	 * Proxibanque. Attention, sa suppression entra�ne la suppression du client qui
	 * d�tient le compte !
	 * 
	 * @param compteEpargne
	 *            Compte �pargne dont on souhaite r�aliser la suppression
	 */
	void supprimerCompteEpargne(CompteEpargne compteEpargne);
}
