package org.lsi.metier;

import org.lsi.entities.Compte;

public interface CompteMetier {
	
	public Compte saveCompte(Compte cp);
	public Compte getCompte(String code);

}
