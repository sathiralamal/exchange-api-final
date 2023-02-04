package com.stockexchange.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class OrganizationWrapperDto {

    private Integer organizationId;
    private String organizationName;
    private String organizationType;
    private Integer availableStock;
    private Double percentage;
    private Double unitPrice;

    public OrganizationWrapperDto(Integer organizationId, String organizationName, String organizationType, Integer availableStock, Double percentage, Double unitPrice) {
        this.organizationId = organizationId;
        this.organizationName = organizationName;
        this.organizationType = organizationType;
        this.availableStock = availableStock;
        this.percentage = percentage;
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "OrganizationWrapperDto{" +
                "organizationId=" + organizationId +
                ", organizationName='" + organizationName + '\'' +
                ", organizationType='" + organizationType + '\'' +
                ", availableStock=" + availableStock +
                ", percentage=" + percentage +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
