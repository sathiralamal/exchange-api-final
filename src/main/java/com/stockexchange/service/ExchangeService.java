package com.stockexchange.service;

import com.stockexchange.dto.*;
import com.stockexchange.model.Exchange;
import com.stockexchange.model.ExchangeParty;
import com.stockexchange.model.Party;
import com.stockexchange.model.Stock;
import com.stockexchange.repository.ExchangePartyRepository;
import com.stockexchange.repository.ExchangeRepository;
import com.stockexchange.repository.PartyRepository;
import com.stockexchange.repository.StockRepository;

import com.stockexchange.utility.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExchangeService {

    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private ExchangeRepository exchangeRepository;
    @Autowired
    private PartyRepository partyRepository;
    @Autowired
    private ExchangePartyRepository exchangePartyRepository;

    private final static Logger logger = LoggerFactory.getLogger(ExchangeService.class);

    //retrieve available stocks
    public List<StockViewDto> doGetAvailableStocks() {

        logger.info("invoking service layer::doGetAvailableStocks()");
        List<StockViewDto> stockViewDtos = new ArrayList<>();

        List<Stock> openStocks = (List<Stock>) stockRepository.findAll();

        openStocks.forEach(openStock -> {
            StockViewDto stockViewDto = new StockViewDto(new StockWrapperDto(openStock.getStockId(),
                    openStock.getCloseCount(), openStock.getOpenCount()),
                    new OrganizationWrapperDto(openStock.getOrganization().getOrganizationId(),
                            openStock.getOrganization().getOrganizationName(),
                            openStock.getOrganization().getOrganizationType(),
                            openStock.getOrganization().getAvailableStock(),
                            openStock.getOrganization().getPercentage(),
                            openStock.getOrganization().getUnitPrice()),
                    new PartyWrapperDto(openStock.getParty().getPartyId(),
                            openStock.getParty().getPartyName(),
                            openStock.getParty().getEmail()));
            stockViewDtos.add(stockViewDto);
        });

        return stockViewDtos;
    }

    //buy stocks
    public void doBuyStock(BuySellDto buySellDto) {

        logger.info("invoking service layer::doBuyStock()");
        doBuySellStocks(buySellDto);
    }

    //sell stocks
    public void doSellStock(BuySellDto buySellDto) {

        logger.info("invoking service layer::doSellStock()");
        doBuySellStocks(buySellDto);
    }

    private void doDecrementSellerStocks(BuySellDto buySellDto) {

        //decrement stock from seller
        Optional<Stock> optionalSellerStock = stockRepository.findById(buySellDto.getSellerId());
        if (optionalSellerStock.isEmpty()) {
            //throw custom exception
        }
        Stock stockSeller = optionalSellerStock.get();
        stockSeller.setOpenCount(optionalSellerStock.get().getOpenCount() - buySellDto.getCount());

        stockRepository.save(stockSeller);
    }

    private void doIncrementBuyerStocks(BuySellDto buySellDto) {

        //increment stock from buyer
        Optional<Stock> optionalBuyerStock = stockRepository.findById(buySellDto.getBuyerId());
        if (optionalBuyerStock.isEmpty()) {
            //throw custom exception
        }
        Stock stockBuyer = optionalBuyerStock.get();
        stockBuyer.setOpenCount(optionalBuyerStock.get().getOpenCount() + buySellDto.getCount());

        stockRepository.save(stockBuyer);
    }

    private void doPersistExchangeParty(BuySellDto buySellDto, Exchange exchange) {

        //record buyer in exchange party
        Optional<Party> optionalBuyerParty = partyRepository.findById(buySellDto.getBuyerId());
        if (optionalBuyerParty.isPresent()) {
            //throw custom exception
        }
        //record seller in exchange party
        Optional<Party> optionalSellerParty = partyRepository.findById(buySellDto.getSellerId());
        if (optionalSellerParty.isPresent()) {
            //throw custom exception
        }

        exchangePartyRepository.save(new ExchangeParty(Constant.EXCHANGE_PARTY_BUYER, exchange,
                optionalBuyerParty.get()));
        exchangePartyRepository.save(new ExchangeParty(Constant.EXCHANGE_PARTY_SELLER, exchange,
                optionalSellerParty.get()));
    }

    private void doBuySellStocks(BuySellDto buySellDto) {

        //increment buyer stocks as per the transaction
        doIncrementBuyerStocks(buySellDto);
        //decrement seller stocks as per the transaction
        doDecrementSellerStocks(buySellDto);

        //persist exchange details for the transaction
        Exchange exchange = exchangeRepository.save(new Exchange(LocalDateTime.now(), buySellDto.getUnitPrice(),
                buySellDto.getCount(), buySellDto.getCount() * buySellDto.getUnitPrice(),
                buySellDto.getStockId()));
        //persist exchange & relevant party details
        doPersistExchangeParty(buySellDto, exchange);
    }
}
