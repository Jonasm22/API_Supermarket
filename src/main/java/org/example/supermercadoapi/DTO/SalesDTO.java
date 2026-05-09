package org.example.supermercadoapi.DTO;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SalesDTO {

    //data sales
    private Long id;
    private LocalDate date;
    private String state;


    //data branch
    private Long branchId;

    //detail sales
    private List<SaleDetailsDTO> details;

    //total sales
    private Double total;

}
