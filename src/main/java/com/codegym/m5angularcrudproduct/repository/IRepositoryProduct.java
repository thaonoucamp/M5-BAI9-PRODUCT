package com.codegym.m5angularcrudproduct.repository;

import com.codegym.m5angularcrudproduct.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface IRepositoryProduct extends CrudRepository<Product, Long> {
}
