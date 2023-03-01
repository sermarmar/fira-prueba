package com.demo.domain.service;

import com.demo.domain.repository.PersonRepository;
import com.demo.infraestructure.entity.PersonEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonServiceImplTest {

	@InjectMocks
	private PersonServiceImpl impl;

	@Mock
	private PersonRepository repository;

	@Test
	void given_name_when_filtering_by_name_then_repository_is_verified() {
		this.impl.getListByName("::test::");

		verify(this.repository).findByName("::test::");
	}

	@Test
	void given_name_when_filtering_by_name_then_persons_is_returned() {
		when(this.repository.findByName(anyString()))
			.thenReturn(
				List.of(new PersonEntity().setId(1L)
				.setName("::name::")
			));

		List<PersonEntity> persons = this.impl.getListByName("::test::");

		assertEquals(List.of(new PersonEntity().setId(1L).setName("::name::")), persons);
	}

	@Test
	void given_list_of_ids_when_get_all_persons_then_repository_is_verified() {
		this.impl.getListByIds(List.of(1L, 2L, 3L));

		verify(this.repository).findAll();
	}

	@Test
	void given_name_when_filtering_by_ids_then_persons_is_returned() {
		when(this.repository.findAll())
			.thenReturn(
				List.of(new PersonEntity().setId(1L)
					.setName("::name::")
				));

		List<PersonEntity> persons = this.impl.getListByIds(List.of(1L, 2L, 3L));

		assertEquals(List.of(new PersonEntity().setId(1L).setName("::name::")), persons);
	}

}