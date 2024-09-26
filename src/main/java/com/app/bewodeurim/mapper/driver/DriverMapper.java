package com.app.bewodeurim.mapper.driver;

import com.app.bewodeurim.domain.driver.DriverDTO;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Driver;

@Mapper
public interface DriverMapper {
    //기사정보 입력

    public void insertDriver(DriverDTO driverDTO);

}
