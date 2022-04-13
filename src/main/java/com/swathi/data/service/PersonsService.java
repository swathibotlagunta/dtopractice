package com.swathi.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swathi.data.model.Persons;
import com.swathi.data.repository.PersonsRepository;

import dto.PersonRequest;
import dto.PersonResponse;

@Service
public class PersonsService {

	@Autowired
	private PersonsRepository repo;

	public PersonResponse savePerson(PersonRequest pReq) {

		Persons p = new Persons();
		p.setFirstName(pReq.getFirstName());
		p.setLastName(pReq.getLastName());
		p.setAddress(pReq.getAddress());
		p.setCity("Bangalore");

		if (repo.save(p) != null) {
			PersonResponse pr = new PersonResponse();
			pr.setFirstName(p.getFirstName());
			pr.setLastName(p.getLastName());
			pr.setAddress(p.getAddress());
			pr.setCity(p.getCity());
			return pr;
		} else {
			return null;
		}
	}

	public void delete(long id) {
		repo.deleteById(id);
	}
}
