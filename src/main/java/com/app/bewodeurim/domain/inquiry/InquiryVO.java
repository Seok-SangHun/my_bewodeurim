package com.app.bewodeurim.domain.inquiry;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Getter @ToString @EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class InquiryVO {
    @EqualsAndHashCode.Include
    private Long id;
    private String memberId;
    private String inquiryType;
    private String inquiryTitle;
    private String inquiryContent;
    private String createdDate;
    private String updatedDate;

    public InquiryDTO toDTO() {
        InquiryDTO inquiryDTO = new InquiryDTO();
        inquiryDTO.setId(id);
        inquiryDTO.setMemberId(memberId);
        inquiryDTO.setInquiryType(inquiryType);
        inquiryDTO.setInquiryTitle(inquiryTitle);
        inquiryDTO.setInquiryContent(inquiryContent);
        inquiryDTO.setCreatedDate(createdDate);
        inquiryDTO.setUpdatedDate(updatedDate);
        return inquiryDTO;
    }
}

