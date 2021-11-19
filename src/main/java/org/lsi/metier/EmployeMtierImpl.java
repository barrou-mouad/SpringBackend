package org.lsi.metier;

import java.util.List;

import org.lsi.dao.EmployeRepository;
import org.lsi.entities.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class EmployeMtierImpl implements EmployeMetier {
	
	@Autowired
	private EmployeRepository  employeRepository;

	@Override
	public Employe saveEmploye(Employe e) {
		// TODO Auto-generated method stub
		return employeRepository.save(e);
	}

	@Override
	public List<Employe> listEmployes() {
		// TODO Auto-generated method stub
		return employeRepository.findAll();
	}
	@Override
	public void deleteEmploye(Long code) {
        employeRepository.deleteById(code);
	}
	@Override
	public Employe EmployeById(Long code) {
		return employeRepository.findById(code).get();
	}
	
	@Override
	public void save(Employe emp) {
		employeRepository.save(emp);	
		
	}
	@Override
	public List<Employe> getNot(Long id) {
		// TODO Auto-generated method stub
		return employeRepository.getNotIn(id);
	}

}
