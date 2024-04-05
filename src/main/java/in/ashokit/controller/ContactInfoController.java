package in.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.entity.Contact;
import in.ashokit.service.ContactService;

@Controller
public class ContactInfoController {
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/contact")							//sending empty object to jsp to bind form data to object.
	public String loadContactForm(Model model) {
		Contact contactObj = new Contact();
		model.addAttribute("contact", contactObj); //key - contact,value - contactObj
		return "contactInfo";
	}
	
	@PostMapping("/saveContact")
	public String saveContact(Contact contact,Model model) {
		boolean isSaved = contactService.saveContact(contact);
		
		if(isSaved) {
			model.addAttribute("success", "Contact saved successfully");
		}
		else {
			model.addAttribute("error", "Failed to save contact");
		}
		return "contactInfo";
	}
	
	@GetMapping("/viewContacts")
	public String viewAllContacts(Model model) {   			//Model obj is used to send the data from Controller to UI.
		List<Contact> allContacts = contactService.getAllContacts();
		model.addAttribute("contacts", allContacts);
		return "contacts";
	}

}
