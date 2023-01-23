package pl.io_proj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import pl.io_proj.model.DBUser;
import pl.io_proj.repository.DBUserRepository;
import pl.io_proj.repository.ProductRepository;
import pl.io_proj.repository.RecipeRepository;
import pl.io_proj.service.DBUserService;
import pl.io_proj.service.ProductService;

import java.util.Scanner;

@SpringBootApplication(exclude = {ReactiveSecurityAutoConfiguration.class})
public class IoProjApplication {

	public static void main(String[] args) {
		//SpringApplication.run(IoProjApplication.class, args);

		ConfigurableApplicationContext context = SpringApplication.run(IoProjApplication.class, args);
		DBUserRepository dbUserRepository= context.getBean(DBUserRepository.class);
		ProductRepository productRepository = context.getBean(ProductRepository.class);
		RecipeRepository recipeRepository = context.getBean(RecipeRepository.class);

		DBUserService userS = context.getBean(DBUserService.class);
//		s.addDBUser(new DBUser("user1", "pass1", "a", "a", 1, 1, 1));
//		userS.addDBUser(new DBUser("admin", "admin", "a", "a", 1, 1, 1));
//
//		ProductService prodS = context.getBean(ProductService.class);
//		System.out.println(prodS.addProduct("rzodkiew",null,null,6));
//		System.out.println(prodS.addProduct("maslo","fajna jest",null,9));
//		System.out.println(prodS.addProduct("BigMac",null,null,2000));
//		System.out.println(prodS.addProduct("burak",null,null,4));
//		System.out.println(prodS.addProduct("drzewo","bo tak","dupa",6));
//		System.out.println(prodS.addProduct("rzodkiew",null,null,15));
//		System.out.println(prodS.addProduct(null,null,null,15));

		Scanner input = new Scanner(System.in);
		input.nextLine();
	}

}
