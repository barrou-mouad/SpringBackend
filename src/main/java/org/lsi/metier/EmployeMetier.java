package org.lsi.metier;

import java.util.List;

import org.lsi.entities.Employe;

public interface EmployeMetier {
	
	public Employe saveEmploye(Employe e);
	public List<Employe> listEmployes();
	public void deleteEmploye(Long code);
	public Employe EmployeById(Long code);
	public void save(Employe emp);
	public List<Employe> getNot(Long id);
}
