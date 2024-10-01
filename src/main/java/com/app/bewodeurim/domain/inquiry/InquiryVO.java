package com.app.bewodeurim.domain.inquiry;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @ToString @EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class InquiryVO {
    @EqualsAndHashCode.Include
    private Long id;
    private Long memberId;
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

