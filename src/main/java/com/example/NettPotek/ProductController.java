package com.example.NettPotek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ProductController {

    @Autowired
    ProductService productService ;

    @PostMapping("/createProduct")
    @ResponseBody
    public ResponseEntity createProduct(@RequestBody Product product){

        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(product));
    }

    @GetMapping("/findAllProduct")
    public List<Product> findAllProduct(){
        return productService.findAll() ;
    }

    @GetMapping("/findProductById/{id}")
    public Product findById(@PathVariable long id){
        return productService.findById(id) ;
    }

    @PutMapping("/updateProduct")
    public Product updateCostumer(@RequestBody Product product){
        return productService.updateCostumer(product);
    }
    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable long id){
        boolean deleted =productService.deleteProduct(id) ;
        if(deleted)
            return new ResponseEntity<>(HttpStatus.OK) ;
        else
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
    }
}
