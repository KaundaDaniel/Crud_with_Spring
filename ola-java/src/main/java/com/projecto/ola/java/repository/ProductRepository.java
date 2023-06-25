package com.projecto.ola.java.repository;

import com.projecto.ola.java.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
