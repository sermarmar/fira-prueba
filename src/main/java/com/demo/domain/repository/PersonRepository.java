package com.demo.domain.repository;

import com.demo.infraestructure.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

	List<PersonEntity> findByName(String name);

}
