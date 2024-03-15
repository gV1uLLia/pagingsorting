package ch.noseryoung.sbdemo01.domain.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "products")
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String description;
    private double price;

    public Product(Integer productId, String description, double price) {
        this.productId = productId;
        this.price = price;
        this.description = description;
    }


}
