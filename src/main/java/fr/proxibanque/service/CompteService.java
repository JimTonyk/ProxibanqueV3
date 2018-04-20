package fr.proxibanque.service;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import fr.proxibanque.model.CompteCourant;
import fr.proxibanque.model.CompteEpargne;

public interface CompteService {

	// Opérations relatives aux comptes courants
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
	CompteCourant obtenirCompteEpargne(@PathParam("numeroCompte") String numeroCompte);

	@PUT
	@Path("/Comptes/")
	Response modifierCompteEpargne(CompteEpargne compte);

	@DELETE
	@Path("/Comptes/{numeroCompte}")
	Response supprimerCompteEpargne(@PathParam("numeroCompte") CompteEpargne numeroCompte);

}
