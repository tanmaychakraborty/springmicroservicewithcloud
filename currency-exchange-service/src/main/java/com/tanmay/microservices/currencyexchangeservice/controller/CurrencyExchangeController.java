package com.tanmay.microservices.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tanmay.microservices.currencyexchangeservice.bean.CurrencyExhcange;
import com.tanmay.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment environment;
	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExhcange retriveExchangeValue(
			@PathVariable String from,@PathVariable String to) {
		CurrencyExhcange currencyExhcange= currencyExchangeRepository.findByFromAndTo(from, to);
		if(currencyExhcange==null) {
			throw new RuntimeException("unable to find data for "+ from +"to" + to);
		}
		currencyExhcange.setEnviroment(environment.getProperty("local.server.port"));
		return currencyExhcange;
	}
}
