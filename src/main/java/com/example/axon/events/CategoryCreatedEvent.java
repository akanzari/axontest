package com.example.axon.events;

import java.io.Serializable;

import com.example.axon.domain.Product;

public class CategoryCreatedEvent implements Serializable {

	private static final long serialVersionUID = 1L;

	public final String externalId;

	public final String name;

	public final Product product;

	public CategoryCreatedEvent(String externalId, String name, Product product) {
		this.externalId = externalId;
		this.name = name;
		this.product = product;
	}

}