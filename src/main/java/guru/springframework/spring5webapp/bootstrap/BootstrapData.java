package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.*;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner{

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	
	public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
	
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		
		Publisher p = new Publisher("Sasha", "Brindavan Society", "Thane", "Maharashtra", "400601");	
		
		publisherRepository.save(p);
		
		System.out.println("Number of Publishers added: " + publisherRepository.count());
	
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain driven design", "123123");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		ddd.setPublisher(p);
		p.getBooks().add(ddd);
		
		authorRepository.save(eric);    //Saved in the h2 database
		bookRepository.save(ddd);       //Saved in the h2 database
		publisherRepository.save(p);    //We need to save this in the h2 database again cause we modified it above
		
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE without EJB", "985674");
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		
		noEJB.setPublisher(p);
		p.getBooks().add(noEJB);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		publisherRepository.save(p);
		
		System.out.println("Started in bootstrap");
		System.out.println("Number of Books: " +bookRepository.count());
		System.out.println("Publisher has published: " + p.getBooks().size() + " books!");
		
		
	}
	
}
