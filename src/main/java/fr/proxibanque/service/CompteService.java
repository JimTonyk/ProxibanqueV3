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
 * Cette interface permet de réaliser les opérations du CRUD pour les comptes
 * courant et les comptes épargne associés aux clients de l'agence Proxibanque
 * 
 * @author Ozlem Avci et Jean-Michel Hiltbrunner
 *
 */
@Produces({ "application/xml", "application/json" })
public interface CompteService {

	// Opérations relatives aux comptes courants
	/**
	 * Permet d'ajouter un compte courant à la BDD et au WebService Proxibanque
	 * 
	 * @param compte
	 *            Compte courant à ajouter à la base de données
	 * @return Requête HTTP 200 si le compte a bien été créé
	 */
	@POST
	@Path("/Comptes/")
	Response ajouterCompteCourant(CompteCourant compte);

	/**
	 * Permet d'obtenir toutes les informations nécessaires sur le Compte courant
	 * connaissant son numéro unique(solde, date d'ouverture, détenteur du compte à
	 * partir de son idClient)
	 * 
	 * @param numeroCompte
	 *            numéro du compte dont on souhaite obtenir les informations
	 * @return Compte courant associé au numéro indiqué dans la recherche
	 */
	@GET
	@Path("/Comptes/{numeroCompte}")
	CompteCourant obtenirCompteCourant(@PathParam("numeroCompte") String numeroCompte);

	/**
	 * Permet de modifier les informations sur un compte courant. Cette interface
	 * est pratique si le client dépose un chèque ou des espèces en agence.
	 * 
	 * @param compte
	 *            Numéro du compte courant dont on souhaite modifier les
	 *            informations associées
	 * @return Requête HTTP 200 si les informations ont bien été modifiées ou 304 si
	 *         aucune modification a été faite (cas d'un rollback et/ou de l'absence
	 *         de compte courant)
	 */
	@PUT
	@Path("/Comptes/")
	Response modifierCompteCourant(CompteCourant compte);

	/**
	 * Permet de supprimer un compte courant de la base de données et du WebService
	 * Proxibanque. Attention, sa suppression entraîne la suppression du client
	 * associé !
	 * 
	 * @param numeroCompte
	 *            identifiant du compte courant dont on souhaite la suppression
	 * @return requête HTTP 200 si le compte a bien été supprimé ou 304 si le compte
	 *         n'a pas été supprimé (absence du compte courant et/ou rollback au
	 *         niveau de la base de données)
	 */
	@DELETE
	@Path("/Comptes/{numeroCompte}")
	Response supprimerCompteCourant(@PathParam("numeroCompte") CompteCourant numeroCompte);

	// Opérations relatives aux comptes épargnes
	/**
	 * Permet d'ajouter un compte épargne à la liste des comptes détenus par
	 * Proxibanque
	 * 
	 * @param compte
	 *            Compte épargne à persiter dans la BDD et le WebService
	 * @return Requête HTTP 200 si le compte épargne à bien été ajouté
	 */
	@POST
	@Path("/Comptes/")
	Response ajouterCompteEpargne(CompteEpargne compte);

	/**
	 * Permet de récuperer les informations sur le compte Epargne (détenteur du
	 * compte, date d'ouverture, solde et taux d'interêts) à partir de son numéro de
	 * compte
	 * 
	 * @param numeroCompte
	 *            numéro du compte épargne dont on souhaite obtenir les informations
	 * @return Compte épargne associé au numéro de compte donné en argument
	 */
	@GET
	@Path("/Comptes/{numeroCompte}")
	CompteEpargne obtenirCompteEpargne(@PathParam("numeroCompte") String numeroCompte);

	/**
	 * Permet de modifier les informations sur le compte épargne notamment en cas de
	 * dépot de chèque ou d'espèce dans une agence Proxibanque
	 * 
	 * @param compte
	 *            Compte Epargne dont on souhaite modifier les informations
	 * @return Requête HTTP 200 si les inforamtions ont bien été modifiées ou 304 si
	 *         un rollback de la base de données est fait et/ou le compte épagne
	 *         n'existe pas dans la base
	 */
	@PUT
	@Path("/Comptes/")
	Response modifierCompteEpargne(CompteEpargne compte);

	/**
	 * Permet de supprimer un compte épargne de la liste des comptes suivis par
	 * Proxibanque. Attention, la suppression du compte épargne entraîne la
	 * suppression du client associé !
	 * 
	 * @param numeroCompte
	 *            Numéro du compte epargne dont on souhaite effectuer la suppression
	 * @return Requête HTTP 200 si le compte a bien été supprimé ou 304 si le compte
	 *         n'existe pas et/ou un rollback a été fait dans la base de données
	 */
	@DELETE
	@Path("/Comptes/{numeroCompte}")
	Response supprimerCompteEpargne(@PathParam("numeroCompte") CompteEpargne numeroCompte);

}
