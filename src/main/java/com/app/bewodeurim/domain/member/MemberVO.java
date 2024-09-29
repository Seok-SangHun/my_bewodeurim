package com.app.bewodeurim.domain.member;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
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
    private String createdDate;
    private String updatedDate;
}
