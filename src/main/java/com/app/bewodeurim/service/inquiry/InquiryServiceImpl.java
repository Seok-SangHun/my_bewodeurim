package com.app.bewodeurim.service.inquiry;

import com.app.bewodeurim.domain.inquiry.InquiryDTO;
import com.app.bewodeurim.domain.inquiry.InquiryVO;
import com.app.bewodeurim.domain.pickup.Pagination;
import com.app.bewodeurim.mapper.inquiry.InquiryMapper;
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
    private final InquiryMapper inquiryMapper;

    // 1:1 문의 목록 작성
    @Override
    public void write(InquiryVO inquiryVO) {
        inquiryDAO.save(inquiryVO);
    }

    // 1:1 문의 등록
    public void registerInquiry(InquiryDTO inquiryDTO) {
        inquiryMapper.insertInquiry(inquiryDTO);
    };

    // 특정 회원의 상담 목록 조회
    @Override
    public List<InquiryDTO> getListByMemberId(Long memberId, Pagination pagination) {
        return inquiryDAO.findByMemberId(memberId, pagination);
    }

    @Override
    public int getTotal() {
        return inquiryDAO.getTotal();
    }

    // 전체 상담 목록 조회 (추가된 메서드)
    @Override
    public List<InquiryDTO> getAllInquiries() {
        return inquiryMapper.selectAllInquiries(); // 모든 상담 목록 조회
    }
//    @Override
//    public List<InquiryVO> getInquiriesByMemberId(Long memberId) {
//        return inquiryDAO.findByMemberId(memberId);
//    }
}
