package com.example.axon.aggregates;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateLifecycle;

import com.example.axon.commands.UpdateNIRPhoneCommand;
import com.example.axon.domain.Identifier;
import com.example.axon.domain.IdentifierTypeEnum;
import com.example.axon.events.IdentifiantUpdatedEvent;

public class PhoneMember extends ProductMember {

	private String frameworkAccess;

	@CommandHandler
	public void handle(UpdateNIRPhoneCommand cmd) {
		System.out.println("Update NIR identifier");
		AggregateLifecycle.apply(new IdentifiantUpdatedEvent(cmd.externalId, cmd.productId,
				new Identifier().identifierType(IdentifierTypeEnum.NIR).identifierValue(cmd.nir)));
	}

	public String getFrameworkAccess() {
		return frameworkAccess;
	}

	public PhoneMember frameworkAccess(String frameworkAccess) {
		this.frameworkAccess = frameworkAccess;
		return this;
	}

}