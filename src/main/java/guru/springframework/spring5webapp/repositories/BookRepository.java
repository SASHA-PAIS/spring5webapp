package guru.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import guru.springframework.spring5webapp.domain.*;

public interface BookRepository extends CrudRepository<Book, Long>{

}
