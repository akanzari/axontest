package com.example.axon.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class UpdateRNACarCommand {

	@TargetAggregateIdentifier
	public final String externalId;

	public final String productId;

	public final String nra;

	public UpdateRNACarCommand(String externalId, String productId, String nra) {
		this.externalId = externalId;
		this.productId = productId;
		this.nra = nra;
	}

}
