package com.app.bewodeurim.domain.driver;

import com.app.bewodeurim.domain.member.MemberVO;
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
    private String memberName;
    private String memberEmail;
    private String memberAddressCode;
    private String memberAddressBasic;
    private String memberAddressDetail;
    private String memberPhoneNumber;
    private String memberStatus;
    private String memberType;
    private String memberPassword;
    private String driverBank;
    private String driverBankAccount;
    private String createdDate;
    private String updatedDate;
    private Long cityId;
    private Long regionId;

    public DriverVO toVO() {
        return new DriverVO(id, driverBank, driverBankAccount, createdDate, updatedDate);
    }

    public MemberVO toMemberVO() {
        return new MemberVO(id,memberName,memberEmail,memberAddressCode,memberAddressBasic
        ,memberAddressDetail,memberPhoneNumber,memberStatus,memberPassword,memberType,createdDate,updatedDate);
    }
}
