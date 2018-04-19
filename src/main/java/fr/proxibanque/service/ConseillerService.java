package fr.proxibanque.service;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import fr.proxibanque.model.CompteCourant;
import fr.proxibanque.model.CompteEpargne;

public interface ConseillerService {

	// Opérations relatives aux comptes courants
	@POST
	@Path("/Comptes/")
	Response ajouterCompteCourant(CompteCourant compte);

	@GET
	@Path("/Comptes/{id}")
	CompteCourant obtenirCompteCourant(String id);

	@PUT
	@Path("/Comptes/")
	Response modifierCompteCourant(CompteCourant compte);

	@DELETE
	@Path("/Comptes/{id}")
	Response supprimerCompteCourant(CompteCourant compte);

	// Opérations relatives aux comptes épargnes
	@POST
	@Path("/Comptes/")
	Response ajouterCompteEpargne(CompteEpargne compte);

	@GET
	@Path("/Comptes/{id}")
	CompteCourant obtenirCompteEpargne(String id);

	@PUT
	@Path("/Comptes/")
	Response modifierCompteEpargne(CompteEpargne compte);

	@DELETE
	@Path("/Comptes/{id}")
	Response supprimerCompteEpargne(CompteEpargne compte);

}
