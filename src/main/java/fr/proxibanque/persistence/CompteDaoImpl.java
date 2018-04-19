package fr.proxibanque.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.proxibanque.model.Client;
import fr.proxibanque.model.CompteCourant;
import fr.proxibanque.model.CompteEpargne;

public class CompteDaoImpl implements CompteDao {

	@Override
	public void creerCompteCourant(CompteCourant compteCourant) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		
		CompteCourant compteCourant1 = new CompteCourant();
//		CompteEpargne compteEpargne1 = new CompteEpargne();

		try {
			txn.begin();
			em.persist(compteCourant1);
//			em.persist(compteEpargne1.getClient());
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
	public void creerCompteEpargne(CompteEpargne compteEpargne) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		
//		CompteCourant compteCourant1 = new CompteCourant();
		CompteEpargne compteEpargne1 = new CompteEpargne();

		try {
			txn.begin();
//			em.persist(compteCourant1.getClient());
			em.persist(compteEpargne1.getClient());
			txn.commit();

		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();

		} finally {
			if (em != null) {
				em.close();
				emf.close();
			}
		}
		

	}

	@Override
	public CompteCourant obtenirCompteCourant(int idClient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompteEpargne obtenirCompteEpargne(int idClient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifierCompteCourant(int idClient, CompteCourant compteCourant) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifierCompteEpargne(int idClient, CompteEpargne compteEpargne) {
		// TODO Auto-generated method stub

	}

	@Override
	public void supprimerCompteCourant(int idClient, CompteCourant compteCourant) {
		// TODO Auto-generated method stub

	}

	@Override
	public void supprimerCompteEpargne(int idClient, CompteEpargne compteEpargne) {
		// TODO Auto-generated method stub

	}

}
