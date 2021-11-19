package org.lsi.metier;

import java.util.List;

import org.lsi.entities.Employe;
import org.lsi.entities.Groupe;

public interface GroupeMetier {

	public List<Groupe> getall();

	public void addEmployeToGroupe(Groupe p,Employe e);
	public Groupe save(Groupe  g);
	public Groupe getById(Long id);
	
}
