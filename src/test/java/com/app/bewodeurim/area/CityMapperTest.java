package com.app.bewodeurim.area;

import com.app.bewodeurim.domain.area.CityDTO;
import com.app.bewodeurim.domain.area.CityVO;
import com.app.bewodeurim.domain.driver.DriverDTO;
import com.app.bewodeurim.mapper.area.CityMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CityMapperTest {
    @Autowired
    private CityMapper cityMapper;



    @Test
    public void insertCityTest() {
        CityDTO cityDTO = new CityDTO();
        cityDTO.setCityName("서울");
        cityMapper.insertCity(cityDTO.toVO());
    }

}
