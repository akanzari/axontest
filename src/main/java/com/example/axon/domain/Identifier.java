package com.example.axon.domain;

public class Identifier {

	private IdentifierTypeEnum identifierType;

	private String identifierValue;

	public IdentifierTypeEnum getIdentifierType() {
		return identifierType;
	}

	public Identifier identifierType(IdentifierTypeEnum identifierType) {
		this.identifierType = identifierType;
		return this;
	}

	public String getIdentifierValue() {
		return identifierValue;
	}

	public Identifier identifierValue(String identifierValue) {
		this.identifierValue = identifierValue;
		return this;
	}

}
