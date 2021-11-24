package org.lsi.metier;

import java.util.List;

import org.lsi.dao.GroupeRepository;
import org.lsi.entities.Employe;
import org.lsi.entities.Groupe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class GroupeMetierImpl implements GroupeMetier {
    @Autowired
	private GroupeRepository grp;
	public GroupeMetierImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Groupe> getall() {
		// TODO Auto-generated method stub
		return grp.findAll();
	}

	@Override
	public void addEmployeToGroupe(Groupe g, Employe e) {
	
		
	}

	@Override
	public Groupe save(Groupe g) {
		return grp.save(g);
	}

	@Override
	public Groupe getById(Long id) {
		// TODO Auto-generated method stub
		return grp.findById(id).get();
	}

}
