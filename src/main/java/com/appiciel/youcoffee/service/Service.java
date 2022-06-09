package com.appiciel.youcoffee.service;

/**
 * The interface Service.
 *
 * @param <T> the type parameter
 */
public interface Service<T>{
    /**
     * Create t.
     *
     * @param entity the entity
     * @return the t
     */
    T create(T entity);

    /**
     * Update t.
     *
     * @param entity the entity
     * @param id     the id
     * @return the t
     */
    T update(T entity, String id);

    /**
     * Get t.
     *
     * @param name the name
     * @return the t
     */
    T get(String name);

    /**
     * Delete.
     *
     * @param name the name
     */
    void delete(String name);
}
