package com.app.bewodeurim.service.driver;

import com.app.bewodeurim.domain.driver.DriverDTO;
import com.app.bewodeurim.domain.member.MemberVO;

import java.sql.Driver;
import java.util.List;
import java.util.Optional;

public interface DriverService {
//    기사 회원가입
    public void registerDriver(DriverDTO driverDTO);
    public Optional<DriverDTO> login(DriverDTO driverDTO);
}
