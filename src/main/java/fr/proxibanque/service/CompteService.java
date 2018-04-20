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
	 * 
	 * @param compte
	 * @return
	 */
	@POST
	@Path("/Comptes/")
	Response ajouterCompteCourant(CompteCourant compte);

	@GET
	@Path("/Comptes/{numeroCompte}")
	CompteCourant obtenirCompteCourant(@PathParam("numeroCompte") String numeroCompte);

	@PUT
	@Path("/Comptes/")
	Response modifierCompteCourant(CompteCourant compte);

	@DELETE
	@Path("/Comptes/{numeroCompte}")
	Response supprimerCompteCourant(@PathParam("numeroCompte") CompteCourant numeroCompte);

	// Opérations relatives aux comptes épargnes
	@POST
	@Path("/Comptes/")
	Response ajouterCompteEpargne(CompteEpargne compte);

	@GET
	@Path("/Comptes/{numeroCompte}")
	CompteEpargne obtenirCompteEpargne(@PathParam("numeroCompte") String numeroCompte);

	@PUT
	@Path("/Comptes/")
	Response modifierCompteEpargne(CompteEpargne compte);

	@DELETE
	@Path("/Comptes/{numeroCompte}")
	Response supprimerCompteEpargne(@PathParam("numeroCompte") CompteEpargne numeroCompte);

}
