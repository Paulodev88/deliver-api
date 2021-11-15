package com.code4life.c4ldeliver.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.code4life.c4ldeliver.entities.Order;
import com.code4life.c4ldeliver.entities.OrderStatus;

public class OrderDTO {
	
	private Long id;
	private String address;
	private double latitude;
	private double longitude;
	private Instant moment;
	private OrderStatus status;
	
	private List<ProductDTO> products = new ArrayList<>();
	
	
	public OrderDTO(){}


	public OrderDTO(Long id, String address, double latitude, double longitude, Instant moment, OrderStatus status) {
		super();
		this.id = id;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.moment = moment;
		this.status = status;
	}
	
	
	public OrderDTO(Order orderEntity) {
		super();
		this.id = orderEntity.getId();
		this.address = orderEntity.getAddress();
		this.latitude = orderEntity.getLatitude();
		this.longitude = orderEntity.getLatitude();
		this.moment = orderEntity.getMoment();
		this.status = orderEntity.getStatus();
		this.products = orderEntity.getProducts().stream()
				.map(product -> new ProductDTO(product)).collect(Collectors.toList());
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	public Instant getMoment() {
		return moment;
	}


	public void setMoment(Instant moment) {
		this.moment = moment;
	}


	public OrderStatus getStatus() {
		return status;
	}


	public void setStatus(OrderStatus status) {
		this.status = status;
	}


	public List<ProductDTO> getProducts() {
		return products;
	}


}
