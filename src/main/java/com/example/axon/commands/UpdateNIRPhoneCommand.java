package com.example.axon.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class UpdateNIRPhoneCommand {

	@TargetAggregateIdentifier
	public final String externalId;

	public final String productId;

	public final String nir;

	public UpdateNIRPhoneCommand(String externalId, String productId, String nir) {
		this.externalId = externalId;
		this.productId = productId;
		this.nir = nir;
	}

}
