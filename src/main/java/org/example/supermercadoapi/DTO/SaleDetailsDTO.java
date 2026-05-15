package org.example.supermercadoapi.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaleDetailsDTO {

    private Long id;
    private String productName;
    private Integer quantityProduct;
    private Double priceUnit; // BigDecimal
    private Double subtotal; // BigDecimal

}
