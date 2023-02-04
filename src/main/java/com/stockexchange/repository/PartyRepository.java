package com.stockexchange.repository;

import com.stockexchange.model.Party;
import org.springframework.data.repository.CrudRepository;

public interface PartyRepository extends CrudRepository<Party, Integer> {
}
