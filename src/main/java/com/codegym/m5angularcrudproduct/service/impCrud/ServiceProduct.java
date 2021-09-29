package com.codegym.m5angularcrudproduct.service.impCrud;

import com.codegym.m5angularcrudproduct.model.Product;
import com.codegym.m5angularcrudproduct.repository.IRepositoryProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProduct implements IServiceProduct {
    @Autowired
    IRepositoryProduct repositoryProduct;

    @Override
    public List<Product> getAll() {
        return (List<Product>) repositoryProduct.findAll();
    }

    @Override
    public Product findById(Long id) {
        return repositoryProduct.findById(id).get();
    }

    @Override
    public Product save(Product product) {
        return repositoryProduct.save(product);
    }

    @Override
    public void delete(Long id) {
        repositoryProduct.deleteById(id);
    }
}
