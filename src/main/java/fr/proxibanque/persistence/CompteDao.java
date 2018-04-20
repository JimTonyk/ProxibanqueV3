package fr.proxibanque.persistence;

import fr.proxibanque.model.CompteCourant;
import fr.proxibanque.model.CompteEpargne;

public interface CompteDao {

	void creerCompteCourant(CompteCourant compteCourant);

	void creerCompteEpargne(CompteEpargne compteEpargne);

	CompteCourant obtenirCompteCourant(int idClient);

	CompteEpargne obtenirCompteEpargne(int idClient);

	void modifierCompteCourant(int idClient);

	void modifierCompteEpargne(int idClient, CompteEpargne compteEpargne);

	void supprimerCompteCourant(CompteCourant compteCourant);

	void supprimerCompteEpargne(CompteEpargne compteEpargne);
}
