package com.stockexchange.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Exchange {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer exchangeId;
    private LocalDateTime dateTime;
    private Double rate;
    private Integer count;
    private Double amount;
    private Integer stockId;

    public Exchange(LocalDateTime dateTime, Double rate, Integer count, Double amount, Integer stockId) {
        this.dateTime = dateTime;
        this.rate = rate;
        this.count = count;
        this.amount = amount;
        this.stockId = stockId;
    }

    @Override
    public String toString() {
        return "Exchange{" +
                "exchangeId=" + exchangeId +
                ", dateTime=" + dateTime +
                ", rate=" + rate +
                ", count=" + count +
                ", amount=" + amount +
                ", stockId=" + stockId +
                '}';
    }
}
