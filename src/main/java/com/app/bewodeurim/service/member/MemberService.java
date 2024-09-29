package com.app.bewodeurim.service.member;

import com.app.bewodeurim.domain.member.MemberDTO;

public interface MemberService {
    //일반 회원가입
    public void registerMember(MemberDTO memberDTO);
}
