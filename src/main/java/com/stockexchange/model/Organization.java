package com.stockexchange.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer organizationId;
    private String organizationName;

    private String organizationType;
    private Integer availableStock;
    private Double percentage;

    private Double unitPrice;

    public Organization(String organizationName, String organizationType, Integer availableStock, Double percentage, Double unitPrice) {
        this.organizationName = organizationName;
        this.organizationType = organizationType;
        this.availableStock = availableStock;
        this.percentage = percentage;
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "organizationId=" + organizationId +
                ", organizationName='" + organizationName + '\'' +
                ", organizationType='" + organizationType + '\'' +
                ", availableStock=" + availableStock +
                ", percentage=" + percentage +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
