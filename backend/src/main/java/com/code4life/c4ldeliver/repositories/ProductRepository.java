package com.code4life.c4ldeliver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code4life.c4ldeliver.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
