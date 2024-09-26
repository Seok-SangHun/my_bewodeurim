package com.app.bewodeurim.repository.driver;

import com.app.bewodeurim.domain.driver.DriverVO;
import com.app.bewodeurim.mapper.driver.DriverMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Driver;

@Repository
@RequiredArgsConstructor
public class DriverDAO {
    private final DriverMapper driverMapper;

    public void saveDriver(DriverVO driverVO) {driverMapper.insertDriverInfo(driverVO);}
}
