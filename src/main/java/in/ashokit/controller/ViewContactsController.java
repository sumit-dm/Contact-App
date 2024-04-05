package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import in.ashokit.entity.Contact;
import in.ashokit.service.ContactService;

@Controller
public class ViewContactsController {
	
	@Autowired
	private ContactService service;
	
	@GetMapping("/edit")
	public String editContact(@RequestParam("cid")Integer contactId,Model model) {
		Contact contact = service.getContactById(contactId);
		model.addAttribute("contact", contact);
		return "contactInfo";
	}
	@GetMapping("/delete")
	public String deleteContact(@RequestParam("cid")Integer contactId,Model model) {
		service.deleteContactById(contactId);
		return "redirect:viewContacts";
	}

}
