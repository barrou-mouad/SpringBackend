package org.lsi.services;

import java.util.List;

import org.lsi.entities.Client;
import org.lsi.metier.ClientMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ClientRestService {
	
	@Autowired
	private ClientMetier clientMetier;

	@RequestMapping(value="/clients",method=RequestMethod.POST)
	public String saveClient(@ModelAttribute Client c) {
    clientMetier.saveClient(c);
    return "redirect:/clients";
	}
	

	@RequestMapping(value="/clients",method=RequestMethod.GET)
	public String listClient(Model model) {
	model.addAttribute("clients", clientMetier.listClient())	;
	return "ClientList";
	}
	@RequestMapping(value="/clientAdd",method=RequestMethod.GET)
	public String AddForm(Model model) {
	model.addAttribute("client", new Client())	;
	return "ClientAdd";
	}
	// ClientDetails
	@RequestMapping(value="/ClientDetails",method=RequestMethod.GET)
	public String listClient(Model model,@RequestParam long id) {
    model.addAttribute("client", clientMetier.ClientById(id))	;
	return "ClientDetails";
	}
}


