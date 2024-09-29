package com.app.bewodeurim.service.member;

import com.app.bewodeurim.domain.member.MemberDTO;
import com.app.bewodeurim.domain.member.MemberVO;

import java.util.Optional;

public interface MemberService {
    //일반 회원가입
    public void registerMember(MemberDTO memberDTO);
    public Optional<MemberVO> login(MemberVO memberVO);
}
