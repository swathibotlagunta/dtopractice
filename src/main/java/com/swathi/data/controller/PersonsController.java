package com.swathi.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swathi.data.service.PersonsService;

import dto.PersonRequest;
import dto.PersonResponse;

@RestController
@RequestMapping("/persons")
public class PersonsController {

	@Autowired
	private PersonsService ps;

	@PostMapping("/save")
	ResponseEntity<PersonResponse> savePerson(@RequestBody PersonRequest pReq) {

		return new ResponseEntity<>(ps.savePerson(pReq), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")

	public void delete(@PathVariable("id") long id) {
		ps.delete(id);
	}

}
