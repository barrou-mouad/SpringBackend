package org.lsi.services;

import java.util.List;

import javax.websocket.server.PathParam;
import org.lsi.entities.CompteEpargne;
import org.lsi.entities.Client;
import org.lsi.entities.Compte;
import org.lsi.metier.ClientMetier;
import org.lsi.metier.CompteMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.lsi.entities.CompteCourant;
@Controller
public class CompteRestService {
	
	@Autowired
	private CompteMetier compteMetier;
	@Autowired
	private ClientMetier client;

	@RequestMapping(value="/compteCourant", method=RequestMethod.POST)
	public String saveCompte(@ModelAttribute CompteCourant cp ,Model model) {
		List<Compte> cs= compteMetier.getall();
		int last=(cs.size() - 1)+1;
		cp.setCodeCompte(""+last);
	    compteMetier.saveCompte(cp);
		model.addAttribute("compte",new CompteCourant());
		model.addAttribute("clients",client.listClient());
		return "CompteCourant";
	}
	@RequestMapping(value="/compteEpargne", method=RequestMethod.POST)
	public String saveCompte(@ModelAttribute CompteEpargne cp ,Model model) {
		List<Compte> cs= compteMetier.getall();
		int last=(cs.size() - 1)+1;
		cp.setCodeCompte(""+last);
	    compteMetier.saveCompte(cp);
		model.addAttribute("compte",new CompteEpargne());
		model.addAttribute("clients",client.listClient());
		return "CompteEpargne";
	}
	@RequestMapping(value="/comptes/{code}", method=RequestMethod.GET)
	public Compte getCompte(@PathVariable String code) {
		return compteMetier.getCompte(code);
	}
	@GetMapping("/comptesAdd")
	public String ChoiceCompte () {
		return "CompteChoice" ;
	}
	@GetMapping("/compteCourantAdd")
	public String CompteCourant (Model model) {
		model.addAttribute("compte",new CompteCourant());
		model.addAttribute("clients",client.listClient());
		return "CompteCourant" ;
	}
	@GetMapping("/compteEpargneAdd")
	public String CompteEpargne (Model model) {
		model.addAttribute("compte",new CompteEpargne());
		model.addAttribute("clients",client.listClient());
		return "CompteEpargne" ;
	}
	@PostMapping("SaveCourant")
	public String saveCompte1(@ModelAttribute CompteCourant cmpt) {
		System.out.print(cmpt.getSolde());
	return 	"CompteCourant";	
	}
}
