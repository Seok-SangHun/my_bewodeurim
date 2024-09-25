package com.app.bewodeurim.member;

import com.app.bewodeurim.domain.member.MemberDTO;
import com.app.bewodeurim.domain.member.MemberVO;


import com.app.bewodeurim.mapper.member.MemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Slf4j

public class MemberMapperTests {
    @Autowired
    private MemberMapper memberMapper;


    @Test
    public void insertTest() {
        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setMemberName("사용자1");
        memberDTO.setMemberEmail("test1234@gmail.com");
        memberDTO.setMemberPassword("123456");
        memberDTO.setMemberPhoneNumber("01012341234");
        memberDTO.setMemberAddressCode("357703");
        memberDTO.setMemberAddressBasic("서울시 강남구 테헤란로2");
        memberDTO.setMemberAddressDetail("주류성빌딩 703호");

        memberMapper.insertMemberInfo(memberDTO.toVO());
        log.info("MemberDTO: {}", memberDTO);
    }
}





















