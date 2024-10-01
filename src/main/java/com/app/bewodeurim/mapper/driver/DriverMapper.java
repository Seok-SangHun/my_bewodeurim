package com.app.bewodeurim.mapper.driver;

import com.app.bewodeurim.domain.driver.DriverDTO;
import com.app.bewodeurim.domain.driver.DriverVO;
import com.app.bewodeurim.domain.member.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Driver;
import java.util.Optional;

@Mapper
public interface DriverMapper {
    //기사정보 입력

    public void insertDriverInfo(DriverVO driverVO);

    //기사 로그인
    public Optional<DriverDTO> selectByDriverEmailAndMemberPassword(DriverDTO driverDTO);
}
