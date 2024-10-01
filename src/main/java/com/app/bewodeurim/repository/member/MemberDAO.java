package com.app.bewodeurim.repository.member;

import com.app.bewodeurim.domain.member.MemberDTO;
import com.app.bewodeurim.domain.member.MemberVO;
import com.app.bewodeurim.mapper.member.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberDAO {
    private final MemberMapper memberMapper;

    //회원가입
    public void saveMember(MemberVO memberVO) {memberMapper.insertMemberInfo(memberVO);}

    //    로그인
    public Optional<MemberVO> findByMemberEmailAndMemberPassword(MemberVO memberVO){
        return memberMapper.selectByMemberEmailAndMemberPassword(memberVO);
    }
}
