package com.stockexchange.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class StockWrapperDto {
    private Integer stockId;
    private Integer closeCount;
    private Integer openCount;

    public StockWrapperDto(Integer stockId, Integer closeCount, Integer openCount) {
        this.stockId = stockId;
        this.closeCount = closeCount;
        this.openCount = openCount;
    }

    @Override
    public String toString() {
        return "StockWrapperDto{" +
                "stockId=" + stockId +
                ", closeCount=" + closeCount +
                ", openCount=" + openCount +
                '}';
    }
}
