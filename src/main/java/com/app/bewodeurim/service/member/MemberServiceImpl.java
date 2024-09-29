package com.app.bewodeurim.service.member;

import com.app.bewodeurim.domain.member.MemberDTO;
import com.app.bewodeurim.domain.member.MemberVO;
import com.app.bewodeurim.repository.member.MemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Primary
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class MemberServiceImpl implements MemberService {
    private final MemberDAO memberDAO;

    @Override
    public void registerMember(MemberDTO memberDTO) {
        MemberVO memberVO = new MemberVO();
        memberDAO.saveMember(memberDTO.toVO());
    }
}
