package com.projecto.ola.java.repository;

import com.projecto.ola.java.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    private List<Product>products= new ArrayList<Product>();
    private Integer ultimoId=0;
    /**
     * Metodo para retornar todos os produto
     * @return Lista dos produtos
     * */
    public List<Product> obterTodos(){
        return products;
    }


    /**
     * Metodo que retona o producto encontrado pelo id
     * @param id
     * @return produto buscado pelo id caso seja encontrado
     * */
    public Optional<Product> obterPorId(Integer id){
        return products
                .stream()
                .filter(product->product.getId()==id)
                .findFirst();
    }
    /**
     * Produto a ser adicionado
     * @param product
     * @return product
     * */
    public Product adicionar(Product product){
        ultimoId++;
        product.setId(ultimoId);
        products.add(product);
        return product;
    }
    /**Metodo para apagar um produto pelo id
     * @param id
     * */
    public void apagar(Integer id){
        products.removeIf(product -> product.getId()==id);
    }
    /**metodo para actualizar o produto */
    public Product actualizar(Product product){
        Optional<Product>productFound=obterPorId(product.getId());
        if (productFound.isEmpty()){
            throw  new InputMismatchException("Product not found");
        }
        apagar(product.getId());
        //adcionando na lista
        products.add(product);
        return product;
    }
}
