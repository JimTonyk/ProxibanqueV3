package fr.proxibanque.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RestClient {
	private static final String PATIENTS = "/Clients";
	private static final String SERVICE_PATIENTS = "http://localhost:8080/proxibanque/services/clientservice";

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		// Cible
		WebTarget putTarget = client.target(SERVICE_PATIENTS).path(PATIENTS);
		// Verbe

		// Méthode put
		fr.proxibanque.model.Client c = new fr.proxibanque.model.Client();
		c.setIdClient(123);
		c.setNom("Beurre");
		c.setPrenom("Franz");
		c.setAdresse("Promenade du cuisinier");
		c.setCodePostal("77000");
		c.setVille("Meaux");
		c.setTelephone("0102030406");
		Response putResponse = putTarget.request().put(Entity.entity(c, MediaType.APPLICATION_XML));

		System.out.println("put =" + putResponse.getStatus());
		client.close();
		putResponse.close();

	}
}
