package com.app.bewodeurim.member;

import com.app.bewodeurim.domain.member.MemberDTO;
import com.app.bewodeurim.domain.member.MemberVO;


import com.app.bewodeurim.mapper.member.MemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Slf4j

public class MemberMapperTests {
    @Autowired
    private MemberMapper memberMapper;


    @Test
    public void insertTest() {
        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setMemberName("홍길동");
        memberDTO.setMemberEmail("test1234@gmail.com");
        memberDTO.setMemberPassword("000000");
        memberDTO.setMemberPhoneNumber("01012341234");
        memberDTO.setMemberAddressCode("357703");
        memberDTO.setMemberAddressBasic("서울시 강남구 테헤란로2");
        memberDTO.setMemberAddressDetail("주류성빌딩 703호");

        memberMapper.insertMemberInfo(memberDTO.toVO());
        log.info("MemberDTO: {}", memberDTO);
    }

    @Test
    public void testSelectByMemberEmailAndMemberPassword(){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMemberEmail("test1234@gmail.com");
        memberDTO.setMemberPassword("000000");

        Optional<MemberVO> foundMember =
                memberMapper.selectByMemberEmailAndMemberPassword(memberDTO.toVO());

//        테이블에서 조회된 회원 정보가 null이 아니라면, 전체 정보 출력
        foundMember.map(MemberVO::toString).ifPresent(log::info);
    }
}





















