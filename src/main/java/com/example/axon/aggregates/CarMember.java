package com.example.axon.aggregates;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateLifecycle;

import com.example.axon.commands.UpdateCgrCommand;
import com.example.axon.commands.UpdateRNACarCommand;
import com.example.axon.domain.Identifier;
import com.example.axon.domain.IdentifierTypeEnum;
import com.example.axon.events.CgrUpdatedEvent;
import com.example.axon.events.IdentifiantUpdatedEvent;

public class CarMember extends ProductMember {

	private String cgr;
	
	@CommandHandler
	public void handle(UpdateRNACarCommand cmd) {
		System.out.println("Update RNA identifier");
		AggregateLifecycle.apply(new IdentifiantUpdatedEvent(cmd.externalId, cmd.productId,
				new Identifier().identifierType(IdentifierTypeEnum.RNA).identifierValue(cmd.nra)));
	}
	
	@CommandHandler
	public void handle(UpdateCgrCommand cmd) {
		System.out.println("Update Cgr");
		AggregateLifecycle.apply(new CgrUpdatedEvent(cmd.externalId, cmd.productId, cmd.cgr));
	}

	@EventSourcingHandler
	protected void on(CgrUpdatedEvent evt) {
		System.out.println("Cgr Updated");
		this.productId(evt.productId);
		this.cgr = evt.cgr;
	}

	public String getCgr() {
		return cgr;
	}

	public CarMember cgr(String cgr) {
		this.cgr = cgr;
		return this;
	}

}