package com.app.bewodeurim.service.inquiry;

import com.app.bewodeurim.domain.inquiry.FaqDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FaqServiceImpl implements FaqService {

    // FAQ 데이터를 저장하는 리스트
    private final List<FaqDTO> faqList;

    public FaqServiceImpl() {
        // 하드코딩된 FAQ 데이터 (추후에 DB에서 가져오는 방식으로 변경 가능)
        faqList = new ArrayList<>();

        // 반복문을 통해 임의의 데이터를 생성
        for (int i = 1; i <= 30; i++) {
            faqList.add(new FaqDTO("질문" + i, "답변" + i));
        }

        // 필요에 따라 추가적인 하드코딩된 데이터 삽입 가능
//        faqList.add(new FaqDTO("수거요청은 어떻게 하나요?", "원하는 날짜 선택 후 집 앞에 놔두시면 됩니다."));
//        faqList.add(new FaqDTO("구독료는 얼마인가요?", "구독료는 나의 구독에서 해당 정보를 확인할 수 있습니다."));
//        faqList.add(new FaqDTO("정말 분리수거를 따로 안해도 되나요?", "네, 저희가 직접 깔끔하게 분리수가 해드립니다."));
    }

    @Override
    public List<FaqDTO> getFaqList(int page, int pageSize) {
        int startIndex = (page - 1) * pageSize; // 각 페이지의 시작 인덱스
        int endIndex = Math.min(startIndex + pageSize, faqList.size()); // 각 페이지의 끝 인덱스

        return faqList.subList(startIndex, endIndex);
    }

    // 전체 FAQ 수를 반환하는 메서드
    @Override
    public int getTotalCount() {
        return faqList.size(); // 전체 데이터 수 반환
    }
}
