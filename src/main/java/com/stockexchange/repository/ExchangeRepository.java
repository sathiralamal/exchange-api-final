package com.stockexchange.repository;

import com.stockexchange.model.Exchange;
import org.springframework.data.repository.CrudRepository;

public interface ExchangeRepository extends CrudRepository<Exchange, Integer> {
}
