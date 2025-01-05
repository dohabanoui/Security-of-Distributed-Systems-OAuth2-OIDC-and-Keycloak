package ma.banouidoha.orderservice.model;

import lombok.*;

@NoArgsConstructor @AllArgsConstructor @Setter @Getter @Builder @ToString
public class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;
}
