package fr.proxibanque.presentation;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import fr.proxibanque.model.Client;

public interface ClientService {
	
	@POST
	@Path("/Clients/")
	Response ajouterClient(Client client);
	
	@GET
	@Path("/Clients/{id}")
	Client obtenirClient(String id);
	
	@PUT
	@Path("/Clients/")
	Response modifierClient (Client client);
	
	@DELETE
	@Path("/Clients/{id}")
	Response supprimerClient(String id);

}
