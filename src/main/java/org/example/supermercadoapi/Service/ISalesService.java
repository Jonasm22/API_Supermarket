package org.example.supermercadoapi.Service;

import org.example.supermercadoapi.DTO.BranchDTO;
import org.example.supermercadoapi.DTO.SalesDTO;

import java.util.List;

public interface ISalesService {

    //Thinks the methodos
    //ONLY DTOS
    //CRUD
    List<SalesDTO> showSales();
    SalesDTO createSales (SalesDTO salesDTO);
    SalesDTO updateSales (Long id, SalesDTO salesDTO);
    void deleteSales(Long id);

}
