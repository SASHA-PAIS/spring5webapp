package guru.springframework.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring5webapp.repositories.BookRepository;


@Controller
public class BookController {
	
	private final BookRepository bookRepository;
	
	/*Because we have a constructor on that, this is a spring managed component because when spring instantiates
	 this controller, it will inject an instance of the book repository into our controller*/
	
	public BookController(BookRepository bookRepository) {       //Dependency injection (Where is it coming from???)
		this.bookRepository = bookRepository;
	}


	@RequestMapping("/books")                            /*Path on the browser*/
	public String getBooks(Model model) {                /*Spring will add this model*/
		
		model.addAttribute("books", bookRepository.findAll());  
		/* At runtime, when spring gets a request to the URL: /books, it is going to execute getBooks() and it's 
		 going to provide this method a model object. Our code says that for that model,
		 we are going to add the attribute "Books" on the model, and we are going to execute the bookRepository which 
		 will give us a list of books out of the database and the list will be assigned to the attribute! This model will be returned back to the view layer and will have an attribute books
		 and a list of books on that, and we'll be able to utilize that inside our view layer 
		 to apply the necessary view that we will be returning to the client..
		 */
		
		return "books/listBooks";   /*Tells spring MVC that we want to send the "books" attribute to the view "listBooks.html".
		 							books/ here is the directory name and not the attribute name. How then is the books attribute being sent to the listBooks.html ???*/
	}
}
