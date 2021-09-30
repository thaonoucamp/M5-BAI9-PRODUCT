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

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        return new ResponseEntity<>(serviceProduct.findById(id), HttpStatus.OK);
    }

    @PostMapping ("")
    public ResponseEntity<Product> create(@RequestBody Product product){
        return new ResponseEntity<>(serviceProduct.save(product), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id,
                                          @RequestBody Product product){
        Product p = serviceProduct.findById(id);
        product.setId(p.getId());
        return new ResponseEntity<>(serviceProduct.save(product), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        serviceProduct.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
