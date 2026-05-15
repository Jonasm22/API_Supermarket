package org.example.supermercadoapi.Mappers;

import org.example.supermercadoapi.DTO.BranchDTO;
import org.example.supermercadoapi.DTO.ProductDTO;
import org.example.supermercadoapi.DTO.SaleDetailsDTO;
import org.example.supermercadoapi.DTO.SalesDTO;
import org.example.supermercadoapi.Entity.Branch;
import org.example.supermercadoapi.Entity.Product;
import org.example.supermercadoapi.Entity.Sales;

public class Mappers {
    /*
        --Builder--
        MAPPER Product -> ProductDto
        MAPPER Sales -> SalesDto
        MAPPER Branch -> BranchesDto
    */

    public static ProductDTO toDto(Product productEntity) {

        if(productEntity == null) return null;
        return ProductDTO.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .category(productEntity.getCategory())
                .price(productEntity.getPrice())
                .quantity(productEntity.getStock())
                .build();

    }

    public static SalesDTO toDto(Sales saleEntity) {
        if (saleEntity == null) return null;

        var detail = saleEntity.getDetails().stream().map(saleDetails ->

                SaleDetailsDTO.builder()
                        .id(saleDetails.getProduct().getId())
                        .productName(saleDetails.getProduct().getName())
                        .quantityProduct(saleDetails.getQuantityProduct())
                        .priceUnit(saleDetails.getUnitPrice())
                        .subtotal(saleDetails.getUnitPrice() * saleDetails.getQuantityProduct())
                        .build()

        ).toList();


        var total = detail.stream()
                .map(SaleDetailsDTO::getSubtotal).reduce(0.0, Double::sum);



        return SalesDTO.builder()
                .id(saleEntity.getId())
                .date(saleEntity.getDate())
                .state(saleEntity.getState())
                .branchId(saleEntity.getBranch().getId())
                .details(detail) // from variable details
                .total(total) // from variable total
                .build();

    }

    public static BranchDTO toDto(Branch branchEntity){

        if(branchEntity == null) return null;

        return BranchDTO.builder()
                .id(branchEntity.getId())
                .name(branchEntity.getName()).
                address(branchEntity.getAddress())
                .build();

    }

}
