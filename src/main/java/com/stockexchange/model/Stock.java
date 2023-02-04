package com.stockexchange.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer stockId;
    private Integer closeCount;
    private Integer openCount;
    @ManyToOne
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;
    @ManyToOne
    @JoinColumn(name = "party_id", nullable = false)
    private Party party;

    public Stock(Integer stockId, Integer closeCount, Integer openCount, Organization organization, Party party) {
        this.stockId = stockId;
        this.closeCount = closeCount;
        this.openCount = openCount;
        this.organization = organization;
        this.party = party;
    }

    public Stock(Integer closeCount, Integer openCount, Organization organization, Party party) {
        this.closeCount = closeCount;
        this.openCount = openCount;
        this.organization = organization;
        this.party = party;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockId=" + stockId +
                ", closeCount=" + closeCount +
                ", openCount=" + openCount +
                ", organization=" + organization +
                ", party=" + party +
                '}';
    }
}
