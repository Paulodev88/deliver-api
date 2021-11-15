package com.code4life.c4ldeliver.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.code4life.c4ldeliver.dto.OrderDTO;
import com.code4life.c4ldeliver.dto.ProductDTO;
import com.code4life.c4ldeliver.entities.Order;
import com.code4life.c4ldeliver.entities.OrderStatus;
import com.code4life.c4ldeliver.entities.Product;
import com.code4life.c4ldeliver.repositories.OrderRepository;
import com.code4life.c4ldeliver.repositories.ProductRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private ProductRepository productRepository;
	
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
	
	
	@Transactional()
	public OrderDTO insert(OrderDTO orderDTO){
		
		Order order = new Order(
				null, 
				orderDTO.getAddress(), 
				orderDTO.getLatitude(), 
				orderDTO.getLongitude(), 
				Instant.now(), 
				OrderStatus.PENDING);
		for (ProductDTO prod : orderDTO.getProducts()) {			
			Product product = productRepository.getById(prod.getId());
			order.getProducts().add(product);
		}
		
		order = repository.save(order);
		
		return new OrderDTO(order);
	}
	
	@Transactional()
	public OrderDTO setDelivered(Long id) {
		Order order = repository.getById(id);
		order.setStatus(OrderStatus.DELIVERED);
		order =  repository.save(order);
		
		return new OrderDTO(order);
	}

}
