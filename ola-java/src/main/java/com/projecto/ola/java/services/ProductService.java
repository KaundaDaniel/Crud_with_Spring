package com.projecto.ola.java.services;

import com.projecto.ola.java.model.Product;
import com.projecto.ola.java.repository.ProductRepositoryOld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepositoryOld productRepository;
    /**
     * Metodo para retornar todos os produto
     * @return Lista dos produtos
     * */
    public List<Product> obterTodos(){
       return productRepository.obterTodos();
    }


    public Optional<Product> obterPorId(Integer id){
        return productRepository.obterPorId(id);
    }
    public Product adicionar(Product product){
        return productRepository.adicionar(product);
    }
    public void apagar(Integer id){
        productRepository.apagar(id);
    }

    public Product actualizar(Product product, Integer id){
        product.setId(id);
        return productRepository.actualizar(product);

    }

}
