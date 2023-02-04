package com.stockexchange.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class StockViewDto {

    private StockWrapperDto stockWrapperDto;
    private OrganizationWrapperDto organizationWrapperDto;
    private PartyWrapperDto partyWrapperDto;

    public StockViewDto(StockWrapperDto stockWrapperDto, OrganizationWrapperDto organizationWrapperDto, PartyWrapperDto partyWrapperDto) {
        this.stockWrapperDto = stockWrapperDto;
        this.organizationWrapperDto = organizationWrapperDto;
        this.partyWrapperDto = partyWrapperDto;
    }

    @Override
    public String toString() {
        return "StockViewDto{" +
                "stockWrapperDto=" + stockWrapperDto +
                ", organizationWrapperDto=" + organizationWrapperDto +
                ", partyWrapperDto=" + partyWrapperDto +
                '}';
    }
}
