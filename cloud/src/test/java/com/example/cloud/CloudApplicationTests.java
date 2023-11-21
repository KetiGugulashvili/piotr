package com.example.cloud;

import com.example.cloud.domain.Person;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CloudApplicationTests {
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	@Order(1)
	public void testAdd() {
		Person person = new Person(1, "keti", "gugulashvili", 24);
		HttpEntity<Person>entity = new HttpEntity<>(person);
		var response = restTemplate.exchange("/persons", HttpMethod.POST, entity, Person.class);
		assertEquals(200, response.getStatusCode().value());
		assertEquals(person, response.getBody());
	}

	@Test
	@Order(2)
	public void testFindById() {
		Person person = restTemplate.getForObject("/persons/{id}", Person.class, 1);
		assertNotNull(person);
		assertEquals(1, person.getId());
	}

	@Test
	@Order(3)
	public void testPut() {
		Person person = new Person(1, "John", "Smith", 30);
		HttpEntity<Person> entity = new HttpEntity<>(person);
		var response = restTemplate.exchange("/persons", HttpMethod.PUT, entity, Person.class);
		assertEquals(200, response.getStatusCode().value());
		assertEquals(person, response.getBody());
	}

}
