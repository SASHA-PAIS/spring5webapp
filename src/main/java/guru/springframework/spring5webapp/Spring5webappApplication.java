package guru.springframework.spring5webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring5webappApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring5webappApplication.class, args);
		
//		When you initialize the app:
//			spring initializes
//			It brings up hibernate
//			Hibernate will see the JPA configuration
//			Creates the database
//			Bootstrap class runs
		
//		Important thing to notice is that we didn't have to write sql statements anywhere
//		Hibernate generates the SQL DDL statements
//		The entities that we create are getting persisted into an actual in memory H2 database
//		Hibernate goes out and creates the database tables based on the JPA definitions/entities
		
//		And when we populate the entities and save, Hibernate creates the SQL statements to insert the data for us
	}
}
