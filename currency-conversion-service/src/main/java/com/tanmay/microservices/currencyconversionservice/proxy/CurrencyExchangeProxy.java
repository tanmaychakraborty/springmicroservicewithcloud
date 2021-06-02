package com.tanmay.microservices.currencyconversionservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tanmay.microservices.currencyconversionservice.bean.CurrencyConversion;

@FeignClient(name="currency-exchange",url="localhost:8000")
public interface CurrencyExchangeProxy {
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retriveExchangeValue(
			@PathVariable String from,@PathVariable String to);

}