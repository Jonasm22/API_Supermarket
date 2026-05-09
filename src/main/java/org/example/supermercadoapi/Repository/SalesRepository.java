package org.example.supermercadoapi.Repository;

import org.example.supermercadoapi.Entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<Sales, Long> {


}
