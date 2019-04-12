package org.ms.Web;

import java.util.List;
import java.util.Optional;

import org.ms.dao.ContactRepository;
import org.ms.entites.Contact;
import org.ms.mapper.ContactMappe;
import org.ms.model.ContactMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.xebia.extras.selma.Selma;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.models.Response;

@RestController
@CrossOrigin("*")

public class ContactRestService {
	
	private static final String  GET_CONTACT="recuperer un contact ";
	@Autowired
	private ContactRepository contactRepository;
	
	Logger logge=LoggerFactory.getLogger(ContactRestService.class.getName());
	
	// si j'ai envoie une methode http avec get vers /contact vas me donner la list des contact il utlise la format json 
	
	@RequestMapping(value="/contacts",method=RequestMethod.GET)
    public List<Contact> getContacts(){
    	return contactRepository.findAll();
    }
	
	
	// in the last version of spring findOne is replaced by findByID this methode return a optional 
	/*@RequestMapping(value="/contacts/{id}",method=RequestMethod.GET)
    public ContactMap getContacts(@PathVariable Long id){
	     ContactMap contact1=null;
	     Contact c= contactRepository.findById(id).orElse(null);
	     ContactMappe mapper=Selma.mapper(ContactMappe.class);
	     contact1=mapper.asContactMapp(c);
	     return  contact1;
    }
	*/
	@RequestMapping(value="/contacts",method=RequestMethod.POST)
    public Contact saveContacts(@RequestBody Contact c){
    	return contactRepository.save(c); 
    }
	
	@RequestMapping(value="/contacts/{id}",method=RequestMethod.DELETE)
    public Boolean  deleteContact(@PathVariable Long id){
    	contactRepository.deleteById(id);
    	return true;
    }
	
	@RequestMapping(value="/contacts/{id}",method=RequestMethod.PUT)
    public Contact updateContacts( @PathVariable Long id, @RequestBody Contact c){
		c.setId(id);
    	return contactRepository.save(c); 
    }
	
	@RequestMapping(value="/cherchercontacts",method=RequestMethod.GET)
    public Page<Contact> ChercherContact(
    		@RequestParam(name="mc",defaultValue="")String mc ,
    		@RequestParam(name="page",defaultValue="0")int page,
    		@RequestParam(name="size",defaultValue="5")int size){
    		return contactRepository.chercher("%"+mc+"%", new PageRequest(page, size));
    }
}
