package org.lsi.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.websocket.server.PathParam;

import org.lsi.dao.GroupeRepository;
import org.lsi.entities.Employe;
import org.lsi.entities.Groupe;
import org.lsi.metier.EmployeMetier;
import org.lsi.metier.EmployeMtierImpl;
import org.lsi.metier.GroupeMetierImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GroupeRestService {
@Autowired
private GroupeMetierImpl grp;
@Autowired
private EmployeMtierImpl emp;

	public GroupeRestService() {
		// TODO Auto-generated constructor stub
	}

@GetMapping("/GroupeList")
public String GroupeList(Model model) {

	model.addAttribute("groupes",grp.getall());
	return "GroupeList";
}

@GetMapping("/GroupeAdd")
public String GroupeAdd(Model model) {

	model.addAttribute("groupes",grp.getall());
	return "GroupeAdd";
}

@GetMapping("/GroupeDetails")
public String GroupeList(Model model,@RequestParam Long id) {
    
	model.addAttribute("groupe",grp.getById(id));
	model.addAttribute("grp",emp.getNot(id));
	return "Groupe";
}
@PostMapping("/AddConfirmer")
public String GroupeList(@RequestParam("id_emp") Long id_emp,@RequestParam("id_grp") Long id_grp) {
Groupe grp1=grp.getById(id_grp);
grp1.getEmploye().add(emp.EmployeById(id_emp));
grp.save(grp1);	
return "redirect:/GroupeDetails?id="+id_grp;
}
}
