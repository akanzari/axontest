package com.example.axon.aggregates;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.AggregateMember;
import org.axonframework.modelling.command.ForwardMatchingInstances;
import org.axonframework.spring.stereotype.Aggregate;

import com.example.axon.commands.CreateCategoryCommand;
import com.example.axon.domain.Car;
import com.example.axon.domain.Phone;
import com.example.axon.events.CategoryCreatedEvent;

@Aggregate
public class CategoryAggregate {

	@AggregateIdentifier
	private String externalId;

	private String name;

	@AggregateMember(type = PhoneMember.class, eventForwardingMode = ForwardMatchingInstances.class)
	private PhoneMember phone;

	@AggregateMember(type = CarMember.class, eventForwardingMode = ForwardMatchingInstances.class)
	private CarMember car;

	public CategoryAggregate() {
	}

	@CommandHandler
	public CategoryAggregate(CreateCategoryCommand cmd) {
		System.out.println("Create category");
		AggregateLifecycle.apply(new CategoryCreatedEvent(cmd.externalId, cmd.name, cmd.product));
	}

	@EventSourcingHandler
	protected void on(CategoryCreatedEvent evt) {
		this.externalId = evt.externalId;
		this.name = evt.name;
		if (evt.product instanceof Car) {
			System.out.println("Car Created");
			Car car = (Car) evt.product;
			this.car = new CarMember().cgr(car.getCgr());
		} else if (evt.product instanceof Phone) {
			System.out.println("Phone Created");
			Phone phone = (Phone) evt.product;
			this.phone = new PhoneMember().frameworkAccess(phone.getFrameworkAccess());
		}
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PhoneMember getPhone() {
		return phone;
	}

	public void setPhone(PhoneMember phone) {
		this.phone = phone;
	}

	public CarMember getCar() {
		return car;
	}

	public void setCar(CarMember car) {
		this.car = car;
	}

}