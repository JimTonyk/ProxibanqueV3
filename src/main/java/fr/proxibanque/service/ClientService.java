package fr.proxibanque.service;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.proxibanque.model.Client;

/**
 * Cette interface permet de r�aliser les op�rations du CRUD aussi bien dans la base de donn�es que dans le WebService Proxibanque
 * @authorOzlem Avci et Jean-Michel Hiltbrunner
 *
 */
@Produces({"application/xml","application/json"})
public interface ClientService {
	
	@POST
	@Path("/Clients/")
	Response ajouterClient(Client client);
	
	@GET
	@Path("/Clients/{idClient}")
	Client obtenirClient(@PathParam("idClient") String id);
	
	@PUT
	@Path("/Clients/")
	Response modifierClient (int idClient, Client client);
	
	@DELETE
	@Path("/Clients/{idClient}")
	Response supprimerClient(@PathParam("idClient") String id);

}
