package com.codegym.m5angularcrudproduct.service;

import java.util.List;

public interface IGenericCrud<T> {
    List<T> getAll();

    T findById(Long id);

    T save(T t);

    void delete(Long id);
}
