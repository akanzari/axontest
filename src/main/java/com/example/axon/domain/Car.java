package com.example.axon.domain;

import java.util.List;

public class Car extends Product {

	private String cgr;

	public String getCgr() {
		return cgr;
	}

	public Car cgr(String cgr) {
		this.cgr = cgr;
		return this;
	}

	@Override
	public Car productId(String productId) {
		return (Car) super.productId(productId);
	}

	@Override
	public Car identifiers(List<Identifier> identifiers) {
		return (Car) super.identifiers(identifiers);
	}

}