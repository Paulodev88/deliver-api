package com.code4life.c4ldeliver.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code4life.c4ldeliver.dto.ProductDTO;
import com.code4life.c4ldeliver.services.ProductService;

@RestController
@RequestMapping(value="/products")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<List <ProductDTO>> findAll(){
		
		List<ProductDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	
	}
}
