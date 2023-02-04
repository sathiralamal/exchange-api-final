package com.stockexchange.repository;

import com.stockexchange.model.Stock;
import org.springframework.data.repository.CrudRepository;
public interface StockRepository extends CrudRepository<Stock, Integer> {
}
