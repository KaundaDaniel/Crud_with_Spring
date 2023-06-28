package com.projecto.ola.java.services;

import com.projecto.ola.java.model.Product;
import com.projecto.ola.java.repository.ProductRepository;
import com.projecto.ola.java.repository.ProductRepositoryOld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    /**
     * Metodo para retornar todos os produto
     * @return Lista dos produtos
     * */
    public List<Product> obterTodos(){
       return productRepository.findAll();
    }


    public Optional<Product> obterPorId(Integer id){
        return productRepository.findById(id);
    }
    public Product adicionar(Product product){
        return productRepository.save(product);
    }
    public void apagar(Integer id){
        productRepository.deleteById(id);
    }

    public Product actualizar(Product product, Integer id){
        product.setId(id);
        return productRepository.save(product);

    }

}
