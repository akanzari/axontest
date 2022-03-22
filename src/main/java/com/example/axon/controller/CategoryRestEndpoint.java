package com.example.axon.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.axon.commands.CreateCategoryCommand;
import com.example.axon.commands.UpdateCgrCommand;
import com.example.axon.commands.UpdateNIRPhoneCommand;
import com.example.axon.commands.UpdateRNACarCommand;
import com.example.axon.domain.Car;
import com.example.axon.domain.Identifier;
import com.example.axon.domain.IdentifierTypeEnum;
import com.example.axon.domain.Phone;

@RestController
public class CategoryRestEndpoint {

	private final CommandGateway commandGateway;

	private final EventStore eventStore;

	public CategoryRestEndpoint(CommandGateway commandGateway, EventStore eventStore) {
		this.commandGateway = commandGateway;
		this.eventStore = eventStore;
	}

	@PostMapping("/car")
	public ResponseEntity<String> createCar() {
		Car car = new Car().productId("003").cgr("cgr").identifiers(
				Arrays.asList(new Identifier().identifierValue("2").identifierType(IdentifierTypeEnum.RNA)));
		String id = commandGateway.sendAndWait(new CreateCategoryCommand("004", "car", car));
		return new ResponseEntity<>(id, HttpStatus.CREATED);
	}

	@PatchMapping("/rna")
	public ResponseEntity<Void> updateRNA() {
		commandGateway.sendAndWait(new UpdateRNACarCommand("004", "003", "98"));
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PatchMapping("/cgr")
	public ResponseEntity<Void> updateCGR() {
		commandGateway.sendAndWait(new UpdateCgrCommand("004", "003", "cgr1"));
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/phone")
	public ResponseEntity<String> createPhone() {
		Phone phone = new Phone().productId("001").frameworkAccess("frameworkAccess").identifiers(
				Arrays.asList(new Identifier().identifierValue("1").identifierType(IdentifierTypeEnum.NIR)));
		String id = commandGateway.sendAndWait(new CreateCategoryCommand("002", "phone", phone));
		return new ResponseEntity<>(id, HttpStatus.CREATED);
	}

	@PatchMapping("/nir")
	public ResponseEntity<Void> updateNIR() {
		commandGateway.sendAndWait(new UpdateNIRPhoneCommand("002", "001", "520"));
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/events/{externalId}")
	public ResponseEntity<List<Object>> getEvents(@PathVariable String externalId) {
		return new ResponseEntity<>(eventStore.readEvents(externalId).asStream().collect(Collectors.toList()),
				HttpStatus.OK);
	}

}