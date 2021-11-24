package org.lsi.metier;

import java.util.List;

import org.lsi.entities.Compte;

public interface CompteMetier {
	
	public Compte saveCompte(Compte cp);
	public Compte getCompte(String code);
	public List<Compte> getall();


}
