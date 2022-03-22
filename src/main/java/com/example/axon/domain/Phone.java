package com.example.axon.domain;

import java.util.List;

public class Phone extends Product {

	private String frameworkAccess;

	public String getFrameworkAccess() {
		return frameworkAccess;
	}

	public Phone frameworkAccess(String frameworkAccess) {
		this.frameworkAccess = frameworkAccess;
		return this;
	}

	@Override
	public Phone productId(String productId) {
		return (Phone) super.productId(productId);
	}

	@Override
	public Phone identifiers(List<Identifier> identifiers) {
		return (Phone) super.identifiers(identifiers);
	}

}