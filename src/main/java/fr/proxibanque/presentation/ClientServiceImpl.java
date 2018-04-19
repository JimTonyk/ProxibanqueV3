package fr.proxibanque.presentation;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.proxibanque.model.Client;

public class ClientServiceImpl implements ClientService {

	private int initialId = 1000;
	Map<Integer, Client> clients = new HashMap<Integer, Client>();
	private static Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);

	public ClientServiceImpl() {
		initialisation();
	}

	final void initialisation() {
		Client client = new Client();
		client.setNom("Mele");
		client.setPrenom("Jean");
		client.setAdresse("5 Villa Lourcine");
		client.setVille("Paris");
		client.setCodePostal("75014");
		client.setTelephone("0102030405");
		client.setIdClient(initialId);
		clients.put(client.getIdClient(), client);
		initialId++;
	}

	@Override
	public Response ajouterClient(Client client) {
		Response response = null;
		client.setIdClient(initialId);
		clients.put(client.getIdClient(), client);
		response = Response.ok().build();
		initialId++;
		LOGGER.info("Le client " + client.getPrenom() + " " + client.getNom() + " a été ajouté à la liste");
		return response;
	}

	@Override
	public Client obtenirClient(String id) {
		int requete = Integer.parseInt(id);
		Client choix = clients.get(requete);
		LOGGER.info(
				"Des informations sur le client " + choix.getPrenom() + " " + choix.getNom() + " ont été demandées.");
		return choix;
	}

	@Override
	public Response modifierClient(Client client) {
		Response response = null;
		Client modif = clients.get(client.getIdClient());
		if (modif != null) {
			clients.put(client.getIdClient(), client);
			response = Response.ok().build();
			LOGGER.info("Des informations sur le client " + client.getPrenom() + " " + client.getNom()
					+ " ont été modifiées.");
		} else {
			response = Response.notModified().build();
			LOGGER.info(
					"Une tentative de modification de client a été réalisée sans succés. La table n'a pas été modifiée");
		}
		return response;
	}

	@Override
	public Response supprimerClient(String id) {
		Response response = null;
		int requete = Integer.parseInt(id);
		Client client = clients.get(requete);
		if (client != null) {
			LOGGER.info(
					"Le client " + client.getPrenom() + " " + client.getNom() + " a été supprimé de la base clients");
			clients.remove(requete);
			response = Response.ok().build();
		} else
			response = Response.notModified().build();
		LOGGER.info("Une tentative de suppression de client a été réalisée sans succés. La table n'a pas été modifiée");
		return response;
	}

}
