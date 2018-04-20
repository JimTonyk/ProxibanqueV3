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

		try {
			txn.begin();
			em.persist(compteCourant1);
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

		CompteEpargne compteEpargne1 = new CompteEpargne();

		try {
			txn.begin();
			em.persist(compteEpargne1);
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
	public CompteCourant obtenirCompteCourant(int idClient) {

		Client client3 = null;
		CompteCourant compteCourant3 = null;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		try {
			txn.begin();
			compteCourant3.getClient();
			compteCourant3 = em.find(CompteCourant.class, 1);
			compteCourant3.setNumeroCompte(1);
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
		return compteCourant3;
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
	public void supprimerCompteCourant(CompteCourant compteCourant) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		try {
			txn.begin();
			em.remove(em.find(CompteCourant.class, 1));
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
	public void supprimerCompteEpargne(CompteEpargne compteEpargne) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();
			em.remove(em.find(CompteEpargne.class, 2));
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
