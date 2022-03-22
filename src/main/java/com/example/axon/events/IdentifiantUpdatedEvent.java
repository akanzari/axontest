package com.example.axon.events;

import java.io.Serializable;

import com.example.axon.domain.Identifier;

public class IdentifiantUpdatedEvent implements Serializable {

	private static final long serialVersionUID = 1L;

	public final String externalId;

	public final String productId;

	public final Identifier identifier;

	public IdentifiantUpdatedEvent(String externalId, String productId, Identifier identifier) {
		this.externalId = externalId;
		this.productId = productId;
		this.identifier = identifier;
	}

}
