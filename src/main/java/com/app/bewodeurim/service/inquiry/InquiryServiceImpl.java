package com.app.bewodeurim.service.inquiry;

import com.app.bewodeurim.domain.inquiry.InquiryVO;
import com.app.bewodeurim.repository.inquiry.InquiryDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Primary
@Transactional(rollbackFor = Exception.class)
public class InquiryServiceImpl implements InquiryService {
    public final InquiryDAO inquiryDAO;

    @Override
    public void write(InquiryVO inquiryVO) {
        inquiryDAO.save(inquiryVO);
    }
}
