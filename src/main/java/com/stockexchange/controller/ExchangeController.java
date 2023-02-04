package com.stockexchange.controller;

import com.stockexchange.dto.BuySellDto;
import com.stockexchange.dto.StockViewDto;
import com.stockexchange.service.ExchangeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/stock")
public class ExchangeController {

    private final static Logger logger = LoggerFactory.getLogger(ExchangeController.class);
    @Autowired
    private ExchangeService exchangeService;

    @GetMapping(value = "/view")
    public ResponseEntity<List<StockViewDto>> handleAvailableStock() {

        logger.info("invoking controller handler::handleAvailableStock()");
        return new ResponseEntity<>(exchangeService.doGetAvailableStocks(), HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/buy")
    public ResponseEntity<HttpStatus> doHandleBuyStock(@RequestBody BuySellDto buySellDto) {

        logger.info("invoking controller handler::doHandleBuyStock()");
        exchangeService.doBuyStock(buySellDto);

        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PostMapping(value = "/sell")
    public ResponseEntity<HttpStatus> doHandleSellStock(@RequestBody BuySellDto buySellDto) {

        logger.info("invoking controller handler::doHandleSellStock()");
        exchangeService.doSellStock(buySellDto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
