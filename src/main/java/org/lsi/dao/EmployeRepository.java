package org.lsi.dao;

import java.util.List;

import org.lsi.entities.Employe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
	
	@Query(value="select * from employe e where e.code_employe not in (select g.employe_code_employe from EMP_GR g where g.groupes_code_groupe=:x )", 
			  nativeQuery = true)
	public List<Employe> getNotIn(@Param("x") Long id);
}


