package org.example.supermercadoapi.Service.impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.supermercadoapi.DTO.SaleDetailsDTO;
import org.example.supermercadoapi.DTO.SalesDTO;
import org.example.supermercadoapi.Entity.Branch;
import org.example.supermercadoapi.Entity.Product;
import org.example.supermercadoapi.Entity.SaleDetails;
import org.example.supermercadoapi.Entity.Sales;
import org.example.supermercadoapi.Exception.NotFoundException;
import org.example.supermercadoapi.Mappers.Mappers;
import org.example.supermercadoapi.Repository.BranchRepository;
import org.example.supermercadoapi.Repository.ProductRepository;
import org.example.supermercadoapi.Repository.SalesRepository;
import org.example.supermercadoapi.Service.ISalesService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SalesService implements ISalesService {
    private final SalesRepository salesRepository;
    private final ProductRepository productRepository;
    private final BranchRepository branchRepository;


    @Override
    public List<SalesDTO> showSales() {
        List<Sales> sales = salesRepository.findAll();
        List<SalesDTO> salesDTOList = new ArrayList<>();
        SalesDTO dto;
        for(Sales s : sales) {
            dto = Mappers.toDto(s);
            salesDTOList.add(dto);
        }
        return salesDTOList;
    }

    @Override
    public SalesDTO createSales(SalesDTO salesDTO) {
        //Validations
        if(salesDTO == null) throw new RuntimeException("SalesDTO is null");
        if(salesDTO.getBranchId() == null) throw new RuntimeException("Branch is not indicated");
        if(salesDTO.getDetails() == null || salesDTO.getDetails().isEmpty()) throw new RuntimeException("SalesDTO is null");

        //Search Branch
        Branch branch = branchRepository.findById(salesDTO.getBranchId()).orElse(null);
        if(branch == null){
            throw new NotFoundException("Branch not found");
        }
        //create sales
        Sales sales = new Sales();
        sales.setDate(salesDTO.getDate());
        sales.setState(sales.getState());
        sales.setBranch(branch);
        sales.setTotal(salesDTO.getTotal());

        //detail list

        List<SaleDetails> details = new ArrayList<>();
        for(SaleDetailsDTO saleDetailsDTO : salesDTO.getDetails()){
            //Search product by id(dto use id as idProdut)
            Product product = productRepository.findByName(saleDetailsDTO.getProductName()).orElse(null);
                    if( product == null){
                        throw new RuntimeException("Product not found: " + saleDetailsDTO.getProductName());
                    }

            //create details

            SaleDetails saleDetails = new SaleDetails();
            saleDetails.setProduct(product);
            saleDetails.setQuantityProduct(saleDetails.getQuantityProduct());
            saleDetails.setSales(sales);

            details.add(saleDetails);

        }
        // set saleDetails
        sales.setDetails(details);

        // save db

        salesRepository.save(sales);

        //Mapping exit

        SalesDTO salesExit = Mappers.toDto(sales);
        return salesExit;

    }

    @Override
    public SalesDTO updateSales(Long id, SalesDTO salesDTO) {

    }

    @Override
    public void deleteSales(Long id) {

        Sales sales = salesRepository.findById(id).orElse(null);
        if(sales == null)throw new RuntimeException("Sale not found");
        salesRepository.delete(sales);

    }
}
