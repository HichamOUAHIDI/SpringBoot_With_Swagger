package org.ms;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.ms.dao.ContactRepository;
import org.ms.entites.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class TpSpringMicroService1Application implements CommandLineRunner {
	@Autowired
	private ContactRepository contactRepository; 
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration ;
	
	public static void main(String[] args) {
		SpringApplication.run(TpSpringMicroService1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("access ");
//		repositoryRestConfiguration.getCorsRegistry()
//		.addMapping("/**").allowedOrigins("*")
//		.allowedHeaders("*").allowedMethods("OPTIONS","HEAD","GET","PUT","POST","DELETE","PATCH");

		DateFormat df=new SimpleDateFormat("dd/MM/yyy");
		contactRepository.save(new Contact("OUAHIDI", "Hicham", df.parse("13/12/1992"), "hicham.ouahidi@gmail.com",0635601033,"hicham.jpg"));
		contactRepository.save(new Contact("khalid", "wardi", df.parse("14/11/1990"), "khalid.wardi@gmail.com",0635601033,"khalid.jpg"));
		contactRepository.save(new Contact("wafi", "kawtar", df.parse("13/01/1991"), "Kawtar.wafi@gmail.com",0635601033,"hicham.jpg"));
//		
//		contactRepository.findAll().forEach(c->{
//			System.out.println(c.getNom());
//		});	
	}
	
    
}
