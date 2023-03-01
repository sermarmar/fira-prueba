package com.demo.application.controller;

import com.demo.domain.service.PersonService;
import com.demo.infraestructure.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping(produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PersonEntity>> getPersonsByName(@RequestParam("name") String name) {
		return ResponseEntity.ok(this.personService.getListByName(name));
	}

	@GetMapping(value = "/ids", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PersonEntity>> getPersonsByIds(@RequestParam("ids") List<Long> ids) {
		return ResponseEntity.ok(this.personService.getListByIds(ids));
	}

}
