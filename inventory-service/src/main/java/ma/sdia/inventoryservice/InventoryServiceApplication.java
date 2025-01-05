package ma.sdia.inventoryservice;

import ma.sdia.inventoryservice.entities.Product;
import ma.sdia.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            productRepository.save(Product.builder().id("P1").name("Laptop").price(1000).quantity(5).build());
            productRepository.save(Product.builder().id("P2").name("Mouse").price(20).quantity(10).build());
            productRepository.save(Product.builder().id("P3").name("Keyboard").price(50).quantity(7).build());


        };
    }

}
