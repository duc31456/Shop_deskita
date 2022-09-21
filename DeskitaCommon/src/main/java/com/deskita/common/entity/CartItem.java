package com.deskita.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cart_items")
public class CartItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@OneToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public CartItem(Integer quantity, Customer customer) {
		this.quantity = quantity;
		this.customer = customer;
	}

	public CartItem() {
	}

	@Override
	public String toString() {
		return "CartItem [id=" + id + ", quantity=" + quantity + ", customer=" + customer + "]";
	}


}
