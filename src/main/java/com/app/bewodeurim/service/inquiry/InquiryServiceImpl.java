package com.app.bewodeurim.service.inquiry;

import com.app.bewodeurim.domain.inquiry.InquiryVO;
import com.app.bewodeurim.repository.inquiry.InquiryDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
@Transactional(rollbackFor = Exception.class)
public class InquiryServiceImpl implements InquiryService {
    public final InquiryDAO inquiryDAO;

    @Override
    public void completeInquiry(InquiryVO inquiryVO) {
        inquiryDAO.save(inquiryVO);
    }

    @Override
    public List<InquiryVO> getInquiriesByMemberId(Long memberId) {
        return inquiryDAO.findByMemberId(memberId);
    }
}
