package guru.springframework.spring5webapp.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;        //The Id property is mapped to the primary key in the underlying database which is auto generated 
							//for all the new records. 
							//Thus it is used to persist and retrieve object from the database.
	
	private String firstName;
	private String lastName;
	
	@ManyToMany(mappedBy = "authors")
	private Set<Book> books = new HashSet<>();
	
	public Author() {
		
	}

	public Author(String firstName, String lastName) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
		/*Remove books in toString() to avoid circular reference with authors
		 * Authors will print books and each book will in turn print its authors.
		 * Deep recursion will get generated*/
	}


	
}
