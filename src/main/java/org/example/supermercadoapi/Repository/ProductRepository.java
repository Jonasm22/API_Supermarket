package org.example.supermercadoapi.Repository;
import org.example.supermercadoapi.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //Buscar producto por nombre

   // Optional<Product> findByNombre(String nombre);


}
