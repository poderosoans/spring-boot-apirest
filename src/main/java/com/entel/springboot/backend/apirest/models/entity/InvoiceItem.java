package com.entel.springboot.backend.apirest.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="items_invoices")
public class InvoiceItem implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Integer quantity;
	
	// Unidireccional: Dueño de la relación, InvoiceItem contiene al producto, no tiene sentido consultar al producto y sus lineas 
	// Muchos items tienen un Producto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="product_id")
	private Product product;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Double getAmount() {
		return quantity.doubleValue() * product.getPrice();
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}



	private static final long serialVersionUID = 1L;

}
