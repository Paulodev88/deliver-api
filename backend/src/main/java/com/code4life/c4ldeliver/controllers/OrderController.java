package com.code4life.c4ldeliver.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code4life.c4ldeliver.dto.OrderDTO;
import com.code4life.c4ldeliver.services.OrderService;

@RestController
@RequestMapping(value="/orders")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@GetMapping
	public ResponseEntity<List <OrderDTO>> findAll(){
		
		List<OrderDTO> list = service.findOrderWithProducts();
		return ResponseEntity.ok().body(list);
	
	}

}
