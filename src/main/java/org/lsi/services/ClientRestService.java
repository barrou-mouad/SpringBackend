package org.lsi.services;

import java.util.List;

import org.lsi.entities.Client;
import org.lsi.metier.ClientMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ClientRestService {
	
	@Autowired
	private ClientMetier clientMetier;

	@RequestMapping(value="/clients",method=RequestMethod.POST)
	public Client saveClient(@RequestBody Client c) {
		return clientMetier.saveClient(c);
	}

	@RequestMapping(value="/clients",method=RequestMethod.GET)
	public String listClient(Model model) {
	model.addAttribute("clients", clientMetier.listClient())	;
	return "ClientList";
				
				
	}
}


