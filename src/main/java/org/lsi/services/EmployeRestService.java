package org.lsi.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.ui.Model;
import org.lsi.dao.EmployeRepository;
import org.lsi.dao.GroupeRepository;
import org.lsi.entities.Employe;
import org.lsi.entities.Groupe;
import org.lsi.metier.EmployeMetier;
import org.lsi.metier.GroupeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javassist.expr.NewArray;


@Controller
public class EmployeRestService {
	
	@Autowired
	private EmployeMetier employeMetier;

	@Autowired
	private EmployeRepository  employeRepository;
	
	@Autowired
	private GroupeMetier grps;
	
	@RequestMapping(value="/employes",method=RequestMethod.POST)
	public Employe saveEmploye(@RequestBody Employe e) {
		return employeMetier.saveEmploye(e);
	}

	@RequestMapping(value="/employes",method=RequestMethod.GET)
	public List<Employe> listEmployes() {
		return employeMetier.listEmployes();
	}
	
   @GetMapping("/EmployeIndex")
   public String EmployeIndex(Model model) {
	   model.addAttribute("employes", employeMetier.listEmployes());
	   return "EmpolyeList";
   }
//   @GetMapping("/mou")
//   public String EmployeIndex() {
//	   Employe e=new Employe("saloua1");
//	      List<Groupe> g=new ArrayList<Groupe>();
//	   g.add(grps.getById((long) 1));
//	   e.setGroupes(g);
//	   employeMetier.save(e);
//	   
//	   return "ClientDetails";
//   }
   
   @GetMapping("/EmployeDelete")
   public String EmployeIndex(Model model,@RequestParam Long id) {
	   model.addAttribute("employes", employeMetier.listEmployes());
	   employeMetier.deleteEmploye(id);
	   model.addAttribute("employes", employeMetier.listEmployes());
	   return "EmpolyeList";
   }
   
   @GetMapping("/EmployeEdit")
   public String EmployeEdit(Model model,@RequestParam Long id) {
	   System.out.println(id);
	   model.addAttribute("employes", employeMetier.listEmployes());
	   model.addAttribute("employe", employeMetier.EmployeById(id));
	   return "EmployeUpdate";
   }
   
   @GetMapping("/AddEmploye")
   public String EmployeAdd(Model model) {
	   model.addAttribute("employes", employeMetier.listEmployes());
	   model.addAttribute("employe", new Employe());
	   return "EmployeAdd";
   }
   
   @PostMapping("/EmployeAdd")
   public String EmployeAdd(Model model,@ModelAttribute Employe e) {

	   e.setEmployeSup(employeMetier.EmployeById(e.getEmployeSup().getCodeEmploye()));
	   employeMetier.save(e);
	   model.addAttribute("employes", employeMetier.listEmployes());
	   return "redirect:/EmployeIndex";
   }
   
   
   @PostMapping("/EmployeUpdate")
   public String EmployeUpdate(Model model,@ModelAttribute Employe emp) {
	   Long id=Integer.toUnsignedLong(1);
	   Employe e=employeMetier.EmployeById(emp.getEmployeSup().getCodeEmploye());
	   emp.setEmployeSup(e);
	   employeMetier.save(emp);
	   model.addAttribute("employes", employeMetier.listEmployes());
	   return "redirect:/EmployeIndex";
   }
}
