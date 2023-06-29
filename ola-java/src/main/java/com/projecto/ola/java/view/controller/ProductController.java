package com.projecto.ola.java.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.projecto.ola.java.model.Product;
import com.projecto.ola.java.services.ProductService;
import com.projecto.ola.java.shared.ProductDto;
import com.projecto.ola.java.view.model.ProductRequest;
import com.projecto.ola.java.view.model.ProductResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity< List<ProductResponse>> obterTodos(){
        List<ProductDto>productDtos = productService.obterTodos();
        ModelMapper mapper= new ModelMapper();
        List<ProductResponse> productResponses=productDtos.stream()
                .map(product->mapper.map(product,ProductResponse.class)).collect(Collectors.toList());
        return new ResponseEntity<>(productResponses,HttpStatus.OK);
    }

    @PostMapping("/salvar")
    public ResponseEntity<ProductResponse> adicionar(@RequestBody ProductRequest product){
        ModelMapper mapper= new ModelMapper();
        ProductDto productDto = mapper.map(product, ProductDto.class);

        productDto= productService.adicionar(productDto);
        return  new ResponseEntity<>(mapper.map(productDto, ProductResponse.class), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity <Optional<ProductResponse>>obterPorId(@PathVariable Integer id){
        Optional<ProductDto> productDto= productService.obterPorId(id);
        ProductResponse productResponse= new ModelMapper().map(productDto.get(), ProductResponse.class);
        return new ResponseEntity<>(
                Optional.of(productResponse), HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> apagar(@PathVariable Integer id){
         productService.apagar(id);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT) ;
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> actualizarProduct(@RequestBody ProductRequest product, @PathVariable Integer id){
        ModelMapper mapper=new ModelMapper();
        ProductDto productDto= mapper.map(product, ProductDto.class);
        productDto= productService.actualizar(productDto, id);
        return new ResponseEntity<>(
                mapper.map(productDto, ProductResponse.class), HttpStatus.OK
        );

    }

}
