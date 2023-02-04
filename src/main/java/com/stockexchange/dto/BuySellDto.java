package com.stockexchange.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class BuySellDto {

    private Integer stockId;
    private Double unitPrice;
    private Integer count;
    private Integer buyerId;
    private Integer sellerId;

    public BuySellDto(Integer stockId, Double unitPrice, Integer count, Integer buyerId, Integer sellerId) {
        this.stockId = stockId;
        this.unitPrice = unitPrice;
        this.count = count;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
    }

    @Override
    public String toString() {
        return "BuySellDto{" +
                "stockId=" + stockId +
                ", unitPrice=" + unitPrice +
                ", count=" + count +
                ", buyerId=" + buyerId +
                ", sellerId=" + sellerId +
                '}';
    }
}
