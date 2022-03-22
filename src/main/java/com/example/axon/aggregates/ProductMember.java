package com.example.axon.aggregates;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.EntityId;

import com.example.axon.domain.Identifier;
import com.example.axon.events.IdentifiantUpdatedEvent;

public class ProductMember {

	@EntityId
	private String productId;

	private Set<Identifier> identifiers = new HashSet<>();

	@EventSourcingHandler
	public void on(IdentifiantUpdatedEvent evt) {
		System.out.println(evt.identifier.getIdentifierType().name() + " identifier updated");
		this.productId = evt.productId;
		Optional<Identifier> identifierOptional = this.identifiers.stream()
				.filter(item -> item.getIdentifierType().equals(evt.identifier.getIdentifierType())).findFirst();
		if (identifierOptional.isPresent()) {
			Identifier identifier = identifierOptional.get();
			identifier.identifierValue(evt.identifier.getIdentifierValue());
		}
	}

	public String getProductId() {
		return productId;
	}

	public ProductMember productId(String productId) {
		this.productId = productId;
		return this;
	}

	public Set<Identifier> getIdentifiers() {
		return identifiers;
	}

	public ProductMember identifiers(Set<Identifier> identifiers) {
		this.identifiers = identifiers;
		return this;
	}

}