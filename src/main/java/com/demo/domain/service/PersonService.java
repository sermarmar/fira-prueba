package com.demo.domain.service;

import com.demo.infraestructure.entity.PersonEntity;

import java.util.List;

public interface PersonService {

	public List<PersonEntity> getListByName(String name);

	public List<PersonEntity> getListByIds(List<Long> ids);

}
