package com.app.bewodeurim.member;

import com.app.bewodeurim.domain.member.MemberDTO;
import com.app.bewodeurim.repository.member.MemberDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MemberDAOTest {
    @Autowired
    private MemberDAO memberDAO;

    @Test
    public void testMemberDAO() {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMemberName("사용자2");
        memberDTO.setMemberEmail("test1234@gmail.com");
        memberDTO.setMemberPassword("123456");
        memberDTO.setMemberPhoneNumber("01012341234");
        memberDTO.setMemberAddressCode("357703");
        memberDTO.setMemberAddressBasic("서울시 강남구 테헤란로2");
        memberDTO.setMemberAddressDetail("주류성빌딩 703호");
        memberDAO.saveMember(memberDTO.toVO());
        log.info("MemberDAO: {}", memberDTO);
    }
}
