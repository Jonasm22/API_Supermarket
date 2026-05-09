package org.example.supermercadoapi.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Table(name = "SALE_DETAILS")

public class SaleDetails {

    @Id
    @Column(name = "SALE_DETAIL_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    /* SALES */
    @NotNull
    //@OneToOne
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "DETAIL_SALES_ID"  , nullable = false)
    private Sales sales;



    /* Product */

    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "SALE_DETAIL_PRODUCTS", nullable = false)
    private Product product;


    @NotNull
    @Min(1)
    @Column(name = "QUANTITY", nullable = false)
    private Integer quantityProduct;

    @NotNull
    @DecimalMin(value = "0.01")
    @Column(name = "UNIT_PRICE", nullable = false)
    private Double unitPrice; // BigDecimal




// omitimos por temporalemente esta funcion =>

    /* =>
    public BigDecimal subtotal(){

        // COMPROBACIÓN: Verificación de nulos (Null Check)
        // Se asegura de que tanto el precio como la cantidad tengan un valor.
        // Si alguno es 'null', la operación de multiplicación lanzaría una excepción
        // NullPointerException que detendría el programa.
        // Al retornar BigDecimal.ZERO, el programa continúa de forma segura.

        if(unitPrice ==null || quantityProduct == null){
            return BigDecimal.ZERO;
        }
        BigDecimal calculate = unitPrice.multiply(BigDecimal.valueOf(quantityProduct));
        return calculate;
    }
    <==
 */

}
