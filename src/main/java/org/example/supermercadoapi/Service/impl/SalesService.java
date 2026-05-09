package org.example.supermercadoapi.Service.impl;

import org.example.supermercadoapi.DTO.SalesDTO;
import org.example.supermercadoapi.Service.ISalesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService implements ISalesService {
    @Override
    public List<SalesDTO> showSales() {
        return List.of();
    }

    @Override
    public SalesDTO createSales(SalesDTO salesDTO) {
        return null;
    }

    @Override
    public SalesDTO updateSales(Long id, SalesDTO salesDTO) {
        return null;
    }

    @Override
    public void deleteSales(Long id) {

    }
}
