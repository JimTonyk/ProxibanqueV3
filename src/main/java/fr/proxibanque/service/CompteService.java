package fr.proxibanque.service;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.proxibanque.model.CompteCourant;
import fr.proxibanque.model.CompteEpargne;

/**
 * Cette interface permet de r�aliser les op�rations du CRUD pour les comptes
 * courant et les comptes �pargne associ�s aux clients de l'agence Proxibanque
 * 
 * @author Ozlem Avci et Jean-Michel Hiltbrunner
 *
 */
@Produces({ "application/xml", "application/json" })
public interface CompteService {

	// Op�rations relatives aux comptes courants
	/**
	 * Permet d'ajouter un compte courant � la BDD et au WebService Proxibanque
	 * 
	 * @param compte
	 *            Compte courant � ajouter � la base de donn�es
	 * @return Requ�te HTTP 200 si le compte a bien �t� cr��
	 */
	@POST
	@Path("/Comptes/")
	Response ajouterCompteCourant(CompteCourant compte);

	/**
	 * Permet d'obtenir toutes les informations n�cessaires sur le Compte courant
	 * connaissant son num�ro unique(solde, date d'ouverture, d�tenteur du compte �
	 * partir de son idClient)
	 * 
	 * @param numeroCompte
	 *            num�ro du compte dont on souhaite obtenir les informations
	 * @return Compte courant associ� au num�ro indiqu� dans la recherche
	 */
	@GET
	@Path("/Comptes/{numeroCompte}")
	CompteCourant obtenirCompteCourant(@PathParam("numeroCompte") String numeroCompte);

	/**
	 * Permet de modifier les informations sur un compte courant. Cette interface
	 * est pratique si le client d�pose un ch�que ou des esp�ces en agence.
	 * 
	 * @param compte
	 *            Num�ro du compte courant dont on souhaite modifier les
	 *            informations associ�es
	 * @return Requ�te HTTP 200 si les informations ont bien �t� modifi�es ou 304 si
	 *         aucune modification a �t� faite (cas d'un rollback et/ou de l'absence
	 *         de compte courant)
	 */
	@PUT
	@Path("/Comptes/")
	Response modifierCompteCourant(CompteCourant compte);

	/**
	 * Permet de supprimer un compte courant de la base de donn�es et du WebService
	 * Proxibanque. Attention, sa suppression entra�ne la suppression du client
	 * associ� !
	 * 
	 * @param numeroCompte
	 *            identifiant du compte courant dont on souhaite la suppression
	 * @return requ�te HTTP 200 si le compte a bien �t� supprim� ou 304 si le compte
	 *         n'a pas �t� supprim� (absence du compte courant et/ou rollback au
	 *         niveau de la base de donn�es)
	 */
	@DELETE
	@Path("/Comptes/{numeroCompte}")
	Response supprimerCompteCourant(@PathParam("numeroCompte") CompteCourant numeroCompte);

	// Op�rations relatives aux comptes �pargnes
	/**
	 * Permet d'ajouter un compte �pargne � la liste des comptes d�tenus par
	 * Proxibanque
	 * 
	 * @param compte
	 *            Compte �pargne � persiter dans la BDD et le WebService
	 * @return Requ�te HTTP 200 si le compte �pargne � bien �t� ajout�
	 */
	@POST
	@Path("/Comptes/")
	Response ajouterCompteEpargne(CompteEpargne compte);

	/**
	 * Permet de r�cuperer les informations sur le compte Epargne (d�tenteur du
	 * compte, date d'ouverture, solde et taux d'inter�ts) � partir de son num�ro de
	 * compte
	 * 
	 * @param numeroCompte
	 *            num�ro du compte �pargne dont on souhaite obtenir les informations
	 * @return Compte �pargne associ� au num�ro de compte donn� en argument
	 */
	@GET
	@Path("/Comptes/{numeroCompte}")
	CompteEpargne obtenirCompteEpargne(@PathParam("numeroCompte") String numeroCompte);

	/**
	 * Permet de modifier les informations sur le compte �pargne notamment en cas de
	 * d�pot de ch�que ou d'esp�ce dans une agence Proxibanque
	 * 
	 * @param compte
	 *            Compte Epargne dont on souhaite modifier les informations
	 * @return Requ�te HTTP 200 si les inforamtions ont bien �t� modifi�es ou 304 si
	 *         un rollback de la base de donn�es est fait et/ou le compte �pagne
	 *         n'existe pas dans la base
	 */
	@PUT
	@Path("/Comptes/")
	Response modifierCompteEpargne(CompteEpargne compte);

	/**
	 * Permet de supprimer un compte �pargne de la liste des comptes suivis par
	 * Proxibanque. Attention, la suppression du compte �pargne entra�ne la
	 * suppression du client associ� !
	 * 
	 * @param numeroCompte
	 *            Num�ro du compte epargne dont on souhaite effectuer la suppression
	 * @return Requ�te HTTP 200 si le compte a bien �t� supprim� ou 304 si le compte
	 *         n'existe pas et/ou un rollback a �t� fait dans la base de donn�es
	 */
	@DELETE
	@Path("/Comptes/{numeroCompte}")
	Response supprimerCompteEpargne(@PathParam("numeroCompte") CompteEpargne numeroCompte);

}
