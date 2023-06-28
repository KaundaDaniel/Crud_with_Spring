package com.projecto.ola.java.view.controller;

import java.util.List;
import java.util.Optional;

import com.projecto.ola.java.model.Product;
import com.projecto.ola.java.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> obterTodos(){
        return productService.obterTodos();
    }

    @PostMapping("/salvar")
    public Product adicionar(@RequestBody Product product){
    return productService.adicionar(product);
    }
    @GetMapping("/{id}")
    public Optional<Product>obterPorId(@PathVariable Integer id){
        return productService.obterPorId(id);
    }
    @DeleteMapping("/{id}")
    public String apagar(@PathVariable Integer id){
         productService.apagar(id);
         return "Produto apagado com sucecso " + id;
    }
    @PutMapping("/{id}")
    public Product actualizarProduct(@RequestBody Product product, @PathVariable Integer id){
        return productService.actualizar(product, id);

    }

}
