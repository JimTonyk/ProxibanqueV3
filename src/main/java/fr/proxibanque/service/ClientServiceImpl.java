package fr.proxibanque.service;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.proxibanque.model.Client;
import fr.proxibanque.persistence.ClientDao;
import fr.proxibanque.persistence.ClientDaoImpl;

public class ClientServiceImpl implements ClientService {

	private int initialId = 1000;
	Map<Integer, Client> clients = new HashMap<Integer, Client>();
	private static Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);
	ClientDao dao = new ClientDaoImpl();

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
		dao.creerClient(client);
		response = Response.ok().build();
		initialId++;
		LOGGER.info("Le client " + client.getPrenom() + " " + client.getNom() + " a été ajouté à la liste");
		return response;
	}

	@Override
	public Client obtenirClient(String id) {
		int requete = Integer.parseInt(id);
		Client choix = dao.obtenirClient(requete);
		LOGGER.info(
				"Des informations sur le client " + choix.getPrenom() + " " + choix.getNom() + " ont été demandées.");
		return choix;
	}

	@Override
	public Response modifierClient(int idClient, Client client) {
		Response response = null;
		Client modif = dao.obtenirClient(idClient);
		if (modif != null) {
			dao.modifierClient(idClient, client);
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
		Client client = dao.obtenirClient(requete);
		if (client != null) {
			LOGGER.info(
					"Le client " + client.getPrenom() + " " + client.getNom() + " a été supprimé de la base clients");
			dao.supprimerClient(requete);
			response = Response.ok().build();
		} else
			response = Response.notModified().build();
		LOGGER.info("Une tentative de suppression de client a été réalisée sans succés. La table n'a pas été modifiée");
		return response;
	}

}
