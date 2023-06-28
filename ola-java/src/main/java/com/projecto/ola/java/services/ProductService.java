package com.projecto.ola.java.services;

import com.projecto.ola.java.model.Product;
import com.projecto.ola.java.model.exception.ResourceNotFound;
import com.projecto.ola.java.repository.ProductRepository;
import com.projecto.ola.java.repository.ProductRepositoryOld;
import com.projecto.ola.java.shared.ProductDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    /**
     * Metodo para retornar todos os produto
     * @return Lista dos produtos
     * */
    public List<ProductDto> obterTodos(){

        List<Product> products = productRepository.findAll();
        return products.stream().map(product->new ModelMapper().map(product, ProductDto.class))
                .collect(Collectors.toList());
    }


    public Optional<ProductDto> obterPorId(Integer id){
        //Obtendo um optional de producto pelo id
        Optional<Product> product= productRepository.findById(id);
        //Se não encontrar o producto lança uma exception
        if(product.isEmpty()){
            throw new ResourceNotFound("Producto não encotrado!");
        }
        //Convertento o produto em uma dto
        ProductDto productDto= new ModelMapper().map(product.get(), ProductDto.class);
        //criando e retornando um optional de DTO
        return Optional.of(productDto);
    }


    public ProductDto adicionar(ProductDto productDto){
        productDto.setId(null);
        //Criar um objecto mapeado
        ModelMapper mapper= new ModelMapper();
        //converter o nosso ProductDto em Product
        Product product= mapper.map(productDto, Product.class);
        //Salvar o producto no Banco de dados
        product=productRepository.save(product);

        productDto.setId(product.getId());
        return productDto;
    }
    public void apagar(Integer id){
        //Verificar se Existe
        Optional<Product> product= productRepository.findById(id);
        if (product.isEmpty()){
            throw  new ResourceNotFound("Product not Exists");
        } else {
            productRepository.deleteById(id);
        }

    }

    public ProductDto actualizar(ProductDto product, Integer id){
       //Passar o id para o productdto
        product.setId(id);

        //criar um objecto de mapeamento
        ModelMapper mapper=new ModelMapper();
        //converter o productdto em product
        Product product1=mapper.map(product, Product.class);
        //actualiazar o product no banco de dados
        productRepository.save(product1);
        //retorrnar o productDto Actualiazao
        return product;

    }

}
