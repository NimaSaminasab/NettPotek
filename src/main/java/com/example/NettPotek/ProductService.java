package com.example.NettPotek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository ;

    public Product createProduct(Product product) {
        return productRepository.save(product);

    }
    public boolean deleteProduct(Long id) {
        if(productRepository.findById(id)!=null){
            productRepository.deleteById(id);
            return true ;
        }
        return false ;
    }

    public Product findById(long id){
        return productRepository.findById(id).orElse(null) ;
    }

    public List<Product> findAll(){
        return (List<Product>) productRepository.findAll();
    }

    public Product updateCostumer(Product product){
        Product newProduct = productRepository.findById(product.getId()).orElseThrow(() ->new NullPointerException());

        if(product.getName()!=null)
            newProduct.setName(product.getName());
        if(product.getDescription()!=null)
            newProduct.setDescription(product.getDescription());
        if(product.getPrice()!= 0)
            newProduct.setPrice(product.getPrice());
        return productRepository.save(newProduct) ;
    }

}

