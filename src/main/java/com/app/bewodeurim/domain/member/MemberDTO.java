package com.app.bewodeurim.domain.member;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter @ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MemberDTO {
    @EqualsAndHashCode.Include
    private Long id;
    private String memberName;
    private String memberEmail;
    private String memberAddressCode;
    private String memberAddressBasic;
    private String memberAddressDetail;
    private String memberPhoneNumber;
    private String memberStatus;
    private String memberPassword;
    private String memberType;
    private String createdDate;
    private String updatedDate;
    private String status;

    public MemberVO toVO(){
        return new MemberVO(id,memberName,memberEmail,memberAddressCode,memberAddressBasic,memberAddressDetail,memberPhoneNumber,memberStatus,memberType,memberPassword,createdDate,updatedDate);
    }
}
