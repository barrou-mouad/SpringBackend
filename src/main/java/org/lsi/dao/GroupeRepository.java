package org.lsi.dao;

import java.util.List;

import org.lsi.entities.Employe;
import org.lsi.entities.Groupe;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface GroupeRepository extends JpaRepository<Groupe, Long> {



}
