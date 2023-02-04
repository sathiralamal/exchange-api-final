package com.stockexchange.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class ExchangeParty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer exchangePartyId;
    private String exchangeType;
    @ManyToOne
    @JoinColumn(name="exchange_id", nullable=false)
    private Exchange exchange;

    @ManyToOne
    @JoinColumn(name="party_id", nullable=false)
    private Party party;

    public ExchangeParty(String exchangeType, Exchange exchange, Party party) {
        this.exchangeType = exchangeType;
        this.exchange = exchange;
        this.party = party;
    }

    @Override
    public String toString() {
        return "ExchangeParty{" +
                "exchangePartyId=" + exchangePartyId +
                ", exchangeType='" + exchangeType + '\'' +
                ", exchange=" + exchange +
                ", party=" + party +
                '}';
    }
}
