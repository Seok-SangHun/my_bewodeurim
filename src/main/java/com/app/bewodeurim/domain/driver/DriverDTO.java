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
    private String memberPassword;
    private String memberPhoneNumber;
    private String memberAddressCode;
    private String memberAddressBasic;
    private String memberAddressDetail;
    private String memberStatus;
    private String memberType;
    private String driverBank;
    private String driverBankAccount;
    private String createdDate;
    private String updatedDate;
//    얘네는 어쩌지??????
//    private Long cityName;
//    private Long regionName;
    private Long cityId;
    private String cityName;

    public DriverVO toDriverVO() {
        return new DriverVO(id, driverBank, driverBankAccount, createdDate, updatedDate);
    }

    public MemberVO toMemberVO() {
        return new MemberVO(id,memberName,memberEmail,memberAddressCode,memberAddressBasic
        ,memberAddressDetail,memberPhoneNumber,memberStatus,memberType,memberPassword,createdDate,updatedDate);
    }
}
