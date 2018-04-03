/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pl.eiti.rso.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.eiti.rso.domain.entity.Address;
import pl.eiti.rso.domain.entity.CustomerBusiness;
import pl.eiti.rso.domain.entity.CustomerIndividual;
import pl.eiti.rso.domain.entity.DiscountCode;
import pl.eiti.rso.domain.repositories.HibernateDaoImpl;
import pl.eiti.rso.domain.repositories.UserRepository;

import javax.transaction.Transactional;


@RestController
public class DiscountCodeController {

	@Autowired
	private UserRepository repository;

	@Autowired
	private HibernateDaoImpl hibernateDao;

	@RequestMapping(value = "/save")
	@Transactional
	public String index2() {
		Address address = new Address();
		address.setCountry("Polska");
		address.setCity("Warszawa");
		CustomerIndividual customerIndividual = new CustomerIndividual();
		CustomerBusiness customerBusiness = new CustomerBusiness();
		customerBusiness.setCompanyName("Firma-Moja");
		customerBusiness.setDeliveryAddress(address);
		customerBusiness.setEmail("moja@o2.pl");
		customerIndividual.setFirstName("Kamil");
		customerIndividual.setDeliveryAddress(address);
		customerIndividual.setEmail("kamil@o2.pl");
		hibernateDao.save(customerIndividual);
		hibernateDao.save(customerBusiness);
		hibernateDao.flush();
		return "index";
	}

	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/empl")
	public DiscountCode empl() throws JsonProcessingException {
		DiscountCode code = new DiscountCode();
		code.setCode("raz123test");
		repository.save(code);
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(repository.findOne(Long.valueOf(1)));
		return repository.findOne(Long.valueOf(1));
	}

	public void setHibernateDao(HibernateDaoImpl hibernateDao) {
		this.hibernateDao = hibernateDao;
	}
}
