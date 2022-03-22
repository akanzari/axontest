package com.example.axon.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class UpdateCgrCommand {

	@TargetAggregateIdentifier
	public final String externalId;

	public final String productId;

	public final String cgr;

	public UpdateCgrCommand(String externalId, String productId, String cgr) {
		this.externalId = externalId;
		this.productId = productId;
		this.cgr = cgr;
	}

}