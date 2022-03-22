package com.example.axon.domain;

import java.util.ArrayList;
import java.util.List;

public class Product {

	private String productId;

	private List<Identifier> identifiers = new ArrayList<>();

	public String getProductId() {
		return productId;
	}

	public Product productId(String productId) {
		this.productId = productId;
		return this;
	}

	public List<Identifier> getIdentifiers() {
		return identifiers;
	}

	public Product identifiers(List<Identifier> identifiers) {
		this.identifiers = identifiers;
		return this;
	}

}
