package com.app.bewodeurim.mapper.member;

import com.app.bewodeurim.domain.member.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {
    //회원정보 입력
    public void insertMemberInfo(MemberVO memberVO);

    //    로그인
//    Optional<T>
//    제네릭에 전달된 타입의 객체가 null인 상황을 처리하기 위해 사용한다.
//    NPE 발생으로 인해 여러 이슈가 생긴다.
//    Optional 객체를 사용함으로써 NPE를 방지할 수 있고 항상 단일 객체에만 사용해야 한다.
    public Optional<MemberVO> selectByMemberEmailAndMemberPassword(MemberVO memberVO);
}
