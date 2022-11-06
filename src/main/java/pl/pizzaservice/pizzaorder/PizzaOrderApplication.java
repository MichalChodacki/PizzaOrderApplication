package pl.pizzaservice.pizzaorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//
//    Pizza service
//    Requirements
//    Create a service which allows users to
//- Create a pizza
//- Display list of created pizzas
//- Delete a pizza
//- Update a pizza
//    We define pizza as an object with: name, price, size and list of ingredients. Service should
//    be backed by a database of your choice. Use Spring Boot and Maven to create it, and send
//    back a link to the Git repository with a code.

@SpringBootApplication
public class PizzaOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaOrderApplication.class, args);
	}

}
