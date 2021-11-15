package com.code4life.c4ldeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.code4life.c4ldeliver.dto.ProductDTO;
import com.code4life.c4ldeliver.entities.Product;
import com.code4life.c4ldeliver.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	@Transactional(readOnly = true)
	public List<ProductDTO> findAll() {

		List<Product> list = repository.findAll();		
		
		return list.stream().map(product -> new ProductDTO(product)).collect(Collectors.toList());

	}

}
