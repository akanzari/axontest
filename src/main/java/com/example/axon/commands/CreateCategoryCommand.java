package com.example.axon.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import com.example.axon.domain.Product;

public class CreateCategoryCommand {

	@TargetAggregateIdentifier
	public final String externalId;

	public final String name;

	public final Product product;

	public CreateCategoryCommand(String externalId, String name, Product product) {
		this.externalId = externalId;
		this.name = name;
		this.product = product;
	}

}