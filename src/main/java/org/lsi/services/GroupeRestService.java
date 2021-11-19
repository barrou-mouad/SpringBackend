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
@GetMapping("/retirer")
public String GroupeList() {
//Long id=Integer.toUnsignedLong(1);
//Groupe grp1=new Groupe("mouad");
//grp1.setNomGroupe("new");
//List<Employe> e=(List<Employe>) grp1.getEmploye();
//id=Integer.toUnsignedLong(4);

	
//e.add(emp.EmployeById(id));
//Collection<Employe> e1=new Collections();
//List<Employe> e1=new ArrayList<Employe>();
//e1.add(emp.EmployeById(id));
//System.out.println(e1.get(0).getNomEmploye());
//grp1.setEmploye(e1);
//Groupe gr=grp.save(grp1);
//System.out.println(gr.getEmploye().size());

//grp.save(new Groupe("mmm"));
return "ClientDetails";
}}
