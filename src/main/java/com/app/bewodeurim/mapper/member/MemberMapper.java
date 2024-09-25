package com.app.bewodeurim.mapper.member;

import com.app.bewodeurim.domain.member.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    //회원정보 입력
    public void insertMemberInfo(MemberVO memberVO);
}
