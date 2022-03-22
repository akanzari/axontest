package com.example.axon.events;

import java.io.Serializable;

public class CgrUpdatedEvent implements Serializable {

	private static final long serialVersionUID = 1L;

	public final String externalId;

	public final String productId;

	public final String cgr;

	public CgrUpdatedEvent(String externalId, String productId, String cgr) {
		this.externalId = externalId;
		this.productId = productId;
		this.cgr = cgr;
	}

}