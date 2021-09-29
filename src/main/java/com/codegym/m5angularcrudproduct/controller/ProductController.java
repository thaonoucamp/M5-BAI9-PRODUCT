package com.codegym.m5angularcrudproduct.controller;

import com.codegym.m5angularcrudproduct.model.Product;
import com.codegym.m5angularcrudproduct.service.impCrud.IServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    IServiceProduct serviceProduct;

    @GetMapping("")
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(serviceProduct.getAll(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        return new ResponseEntity<>(serviceProduct.findById(id), HttpStatus.OK);
    }

    @PostMapping ("/create")
    public ResponseEntity<Product> create(Product product){
        return new ResponseEntity<>(serviceProduct.save(product), HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id,
                                          @RequestBody Product product){
        Product p = serviceProduct.findById(id);
        product.setId(p.getId());
        product.setName(p.getName());
        product.setPrice(p.getPrice());
        product.setImage(p.getImage());
        return new ResponseEntity<>(serviceProduct.save(product), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        serviceProduct.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
