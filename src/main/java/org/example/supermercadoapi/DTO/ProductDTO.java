package org.example.supermercadoapi.DTO;

import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {

    private Long id;
    private String name;
    private String category;
    private Double price; // BigDecimal
    private int quantity;
}
