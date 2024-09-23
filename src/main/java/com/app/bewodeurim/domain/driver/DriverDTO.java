package com.app.bewodeurim.domain.driver;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@ToString
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class DriverDTO {
    @EqualsAndHashCode.Include
    private Long id;
    private Long memberId;
    private String driverBank;
    private String driverBankAccount;
    private String createdDate;
    private String updatedDate;
    private String memberName;
    private String memberEmail;
    private String memberAddressCode;
    private String memberAddressBasic;
    private String memberAddressDetail;
    private String memberPhoneNumber;
    private String memberStatus;
    private String memberPassword;

    public DriverVO toVO() {
        return new DriverVO(id, memberId, driverBank, driverBankAccount, createdDate, updatedDate);
    }
}
