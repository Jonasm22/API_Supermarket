package org.example.supermercadoapi.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "SALES")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sales {
    @Id
    @Column(name = "SALES_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "DATE_SALES", nullable = false)
    private LocalDate date;

    @NotBlank
    @Column(name = "STATE_SALES", nullable = false, length = 150)
    private String state; // Sale State with enum

    @NotNull
    @Column(name = "TOTAL_SALE", nullable = false)
    private Double total;

    /*
    @NotNull
    @Column(name = "LOGIC_DELETE", nullable = false)
    private Boolean logicDelete = false; // change to variable name -> deleted
     */

    //Branch
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "BRANCH_SALES", nullable = false)
    private Branch branch;



    @OneToMany(mappedBy = "sales")
    private List<SaleDetails> details = new ArrayList<>();



    //1.24
}
