package com.app.bewodeurim.domain.inquiry;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Getter @Setter
@ToString @EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class InquiryDTO {
    @EqualsAndHashCode.Include
    private Long id;
    private String memberId;
    private String inquiryType;
    private String inquiryTitle;
    private String inquiryContent;
    private String createdDate;
    private String updatedDate;

    public InquiryVO toVO(){
        return new InquiryVO(id, memberId, inquiryType, inquiryTitle, inquiryContent, createdDate, updatedDate );
    }
}
