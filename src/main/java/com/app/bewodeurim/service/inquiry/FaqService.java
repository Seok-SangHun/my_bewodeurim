package com.app.bewodeurim.service.inquiry;

import com.app.bewodeurim.domain.inquiry.FaqDTO;

import java.util.List;

public interface FaqService {
    List<FaqDTO> getFaqList(int page, int pageSize);
    int getTotalCount(); // 전체 FAQ 수를 반환하는 메서드
}
