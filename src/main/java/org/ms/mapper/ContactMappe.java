package org.ms.mapper;

import org.mapstruct.Mapper;
import org.ms.entites.Contact;
import org.ms.model.ContactMap;

@Mapper
public interface ContactMappe {
	
	ContactMap asContactMapp(Contact contact);
}
