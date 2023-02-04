package com.stockexchange.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PartyWrapperDto {

    private Integer partyId;
    private String partyName;
    private String email;

    public PartyWrapperDto(Integer partyId, String partyName, String email) {
        this.partyId = partyId;
        this.partyName = partyName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "PartyWrapperDto{" +
                "partyId=" + partyId +
                ", partyName='" + partyName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
