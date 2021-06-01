package com.tanmay.microservices.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tanmay.microservices.currencyexchangeservice.bean.CurrencyExhcange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExhcange, Long> {

	CurrencyExhcange findByFromAndTo(String from,String to);
}
