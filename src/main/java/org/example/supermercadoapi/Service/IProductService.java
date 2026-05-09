package org.example.supermercadoapi.Service;

import org.example.supermercadoapi.DTO.BranchDTO;
import org.example.supermercadoapi.DTO.ProductDTO;
import org.example.supermercadoapi.Entity.Product;

import java.util.List;

public interface IProductService {


    //Thinks the methodos
    //ONLY DTOS
    //CRUD
    List<ProductDTO> showProducts();
    ProductDTO createProduct (ProductDTO productDTO);
    ProductDTO updateProduct (Long id, ProductDTO productDTO);
    void deleteProduct(Long id);

}
