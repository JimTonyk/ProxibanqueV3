package fr.proxibanque.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.proxibanque.model.Client;

public class RestClient {
	private static final String PATIENTS = "/Clients";
	private static final String SERVICE_PATIENTS = "http://localhost:8080/Proxibanque/services/clientservice";
	
	
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		// Cible
		WebTarget target = client.target(SERVICE_PATIENTS).path(PATIENTS).path("/1000");
		WebTarget putTarget = client.target(SERVICE_PATIENTS).path(PATIENTS);
		// Verbe
		Response response = target.request().get();
		Client p = response.readEntity(Client.class);
		//Afficher Get
		System.out.println(p.getNom() + " status " + response.getStatus());
		
		// Méthode put
		Patient patient = new Patient();
		patient.setName("Avrell");
		patient.setId(123);
		Response putResponse = putTarget.request().put(Entity.entity(patient, MediaType.APPLICATION_XML));
		
		System.out.println("put ="+putResponse.getStatus());
		client.close();
		response.close();

}
