package org.example.supermercadoapi.Service.impl;


import org.example.supermercadoapi.DTO.ProductDTO;
import org.example.supermercadoapi.Mappers.Mappers;
import org.example.supermercadoapi.Repository.ProductRepository;
import org.example.supermercadoapi.Service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDTO> showProducts() {
        return productRepository.findAll()
                .stream().map(Mappers::toDto).toList();
    }


    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        return null;
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }
}
