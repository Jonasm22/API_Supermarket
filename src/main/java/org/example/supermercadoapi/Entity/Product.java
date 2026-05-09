package org.example.supermercadoapi.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCT")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Long id;

    @NotBlank
    @Size(max = 150)
    @Column(name = "PRODUCT_NAME", length = 150, nullable = false)
    private String name;


    @NotBlank
    @Size(max = 150)
    @Column(name = "PRODUCT_CATEGORY", length = 150, nullable = false)
    private String category;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false) //only value > 0
    @Column(name = "PRODUCT_PRICE", length = 150, nullable = false)
    private Double price; // BigDecimal

    @NotNull
    @Min(0)
    @Column(name = "PRODUCT_STOCK", nullable = false)
    private int stock; //additional attribute

}
