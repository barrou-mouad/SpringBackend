package org.lsi.services;

import javax.websocket.server.PathParam;

import org.lsi.entities.Versment;
import org.lsi.metier.CompteMetier;
import org.lsi.metier.EmployeMetier;
import org.lsi.metier.OperationMetier;
import org.lsi.metier.PageOperation;
//import org.lsi.metier.PageOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class OperationRestService {
	
	@Autowired
	OperationMetier operationMetier;
	@Autowired
	CompteMetier compteMetier;
	@Autowired
	EmployeMetier employeMetier;
	

	//@RequestMapping(value="/operations",method=RequestMethod.GET)
	// public PageOperation getOperation(
	//		@RequestParam String codeCompte,
	//		@RequestParam int page,
	//		@RequestParam int size) {
	//	return operationMetier.getOperation(codeCompte, page, size);
	//}
	@RequestMapping(value="/versement",method=RequestMethod.PUT)
	public boolean verser(
			@RequestParam String code,
			@RequestParam double montant,
			@RequestParam Long codeEmp) {
		return operationMetier.verser(code, montant, codeEmp);
	}
	@RequestMapping(value="/retrait",method=RequestMethod.PUT) 
	public boolean retirer(
			@RequestParam String code,
			@RequestParam double montant,
			@RequestParam Long codeEmp) {
		return operationMetier.retirer(code, montant, codeEmp);
	}
	@RequestMapping(value="/virement",method=RequestMethod.PUT) 
	public boolean virement(
			@RequestParam String cpte1,
			@RequestParam String cpte2,
			@RequestParam double montant,
			@RequestParam Long codeEmp) {
		return operationMetier.virement(cpte1, cpte2, montant, codeEmp);
	} 
  @GetMapping("VerserPage")
  public String VerserPage(Model model,@RequestParam long idCompte) {
   model.addAttribute("employes", employeMetier.listEmployes());
   model.addAttribute("mycompte",idCompte);
   model.addAttribute("verser", new Versment());
   return "VerserToCompte";
  }
}
