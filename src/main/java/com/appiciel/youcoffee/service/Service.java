package com.appiciel.youcoffee.service;

public interface Service<T>{
    T create(T entity);
    T update(T entity, String id);
    T get(String name);
    void delete(String name);
}
