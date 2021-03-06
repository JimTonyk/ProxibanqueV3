package fr.proxibanque.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.proxibanque.model.Client;
import fr.proxibanque.model.CompteCourant;
import fr.proxibanque.model.CompteEpargne;

public class ClientDaoImpl implements ClientDao {

	@Override
	public void creerClient(Client client) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		Client client1 = new Client();
		Client client2 = new Client();

		CompteCourant compteCourant1 = new CompteCourant();
		CompteEpargne compteEpargne1 = new CompteEpargne();

		// ajout des comptes au client1
		client1.getComptes().add(compteCourant1);
		client1.getComptes().add(compteEpargne1);

		// client.getComptes().add(compteCourant1);
		// client.getComptes().add(compteEpargne1);

		// ajout du client1 aux comptes=FK
		compteCourant1.setClient(client1);
		compteEpargne1.setClient(client1);

		// compteCourant1.setClient(client);
		// compteEpargne1.setClient(client);

		try {
			txn.begin();
			// em.persist(client);
			em.persist(client1);
			em.persist(client2);
			txn.commit();

		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();

		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public Client obtenirClient(int idClient) {

		Client client3 = null;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		try {
			txn.begin();
			client3 = em.find(Client.class, 1);
			client3.setNom("Bob");
			txn.commit();

		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();

		} finally {
			if (em != null) {
				em.close();

			}
		}
		return client3;

	}

	@Override
	public ArrayList<Client> obtenirTousClients() {

		ArrayList<Client> client5 = new ArrayList<>();

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		try {
			txn.begin();
			Query jquery=em.createQuery("Select client From Client client");
//			client5=(ArrayList<Client>)jquery.getResultList();
			System.out.println(jquery.getResultList());
			
			//TypedQuery<Client> queryClients = em.createQuery("from Client", Client.class);
			//client5 = queryClients.getResultList();
			txn.commit();

		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();

		} finally {
			if (em != null) {
				em.close();

			}
		}
		return client5;

	}

	@Override
	public void modifierClient(int idClient, Client client) {
		Client client4 = null;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		try {
			txn.begin();
			client4 = em.find(Client.class, 1);
			client4.setVille("Cherbourg");
			txn.commit();

		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();

		} finally {
			if (em != null) {
				em.close();
			}
		}

	}

	@Override
	public void supprimerClient(int idClient) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		try {
			txn.begin();
			em.remove(em.find(Client.class, 2));
			txn.commit();

		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();

		} finally {
			if (em != null) {
				em.close();
			}
		}
		emf.close();
	}
}
