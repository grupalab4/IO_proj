package pl.io_proj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import pl.io_proj.controller.DBUserController;
import pl.io_proj.model.DBUser;
import pl.io_proj.model.Product;
import pl.io_proj.model.Recipe;
import pl.io_proj.repository.DBUserRepository;
import pl.io_proj.repository.ProductRepository;
import pl.io_proj.repository.RecipeRepository;
import pl.io_proj.service.DBUserService;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication(exclude = {ReactiveSecurityAutoConfiguration.class})
public class IoProjApplication {

	public static void main(String[] args) {
		//SpringApplication.run(IoProjApplication.class, args);

		ConfigurableApplicationContext context = SpringApplication.run(IoProjApplication.class, args);
		DBUserRepository dbUserRepository= context.getBean(DBUserRepository.class);
		ProductRepository productRepository = context.getBean(ProductRepository.class);
		RecipeRepository recipeRepository = context.getBean(RecipeRepository.class);

		DBUserService s = context.getBean(DBUserService.class);
		//s.addDBUser(new DBUser("user1", "pass1", "a", "a", 1, 1, 1));
		s.addDBUser(new DBUser("admin", "admin", "a", "a", 1, 1, 1));

		Scanner input = new Scanner(System.in);
		input.nextLine();
	}

}
