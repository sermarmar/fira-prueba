package com.demo.domain.service;

import com.demo.domain.repository.PersonRepository;
import com.demo.infraestructure.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Transactional(readOnly = true)
	@Override
	public List<PersonEntity> getListByName(String name) {
		return this.personRepository.findByName(name);
	}

	@Transactional(readOnly = true)
	@Override
	public List<PersonEntity> getListByIds(List<Long> ids) {
		return this.personRepository.findAll()
			.stream()
			.filter(person -> ids.contains(person.getId()))
			.collect(Collectors.toList());
	}

}
