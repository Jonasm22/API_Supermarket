package org.example.supermercadoapi.Service.impl;


import org.example.supermercadoapi.DTO.ProductDTO;
import org.example.supermercadoapi.Entity.Product;
import org.example.supermercadoapi.Exception.NotFoundException;
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

        var prod = Product.builder()
                .id(productDTO.getId())
                .name(productDTO.getName())
                .category(productDTO.getCategory())
                .price(productDTO.getPrice())
                .stock(productDTO.getQuantity())
                .build();

        return Mappers.toDto(productRepository.save(prod));
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {

        //Find if the product exists
        Product product = productRepository.findById(id).orElseThrow(()-> new NotFoundException("Product not found"));

        product.setName(product.getName());
        product.setCategory(product.getCategory());
        product.setPrice(product.getPrice());
        product.setStock(product.getStock());

        return Mappers.toDto(productRepository.save(product));
    }

    @Override
    public void deleteProduct(Long id) {
        //Find if the product exists
        if(!productRepository.existsById(id)){
            throw new NotFoundException("Product not found to delete");
        }

        productRepository.deleteById(id);

    }
}
