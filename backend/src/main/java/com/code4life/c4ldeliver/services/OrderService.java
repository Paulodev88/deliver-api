package com.code4life.c4ldeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.code4life.c4ldeliver.dto.OrderDTO;
import com.code4life.c4ldeliver.entities.Order;
import com.code4life.c4ldeliver.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll() {

		List<Order> list = repository.findAll();		
		
		return list.stream().map(order -> new OrderDTO(order)).collect(Collectors.toList());

	}
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findOrderWithProducts() {

		List<Order> list = repository.findOrderWithProducts();		
		
		return list.stream().map(order -> new OrderDTO(order)).collect(Collectors.toList());

	}


}
