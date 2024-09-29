package com.app.bewodeurim.driver;

import com.app.bewodeurim.domain.driver.DriverDTO;
import com.app.bewodeurim.service.driver.DriverService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
@Slf4j
public class DriverServiceTests {
    @Autowired
    private DriverService driverService;

    @Test
    public void testRegisterDriver() {
        DriverDTO driverDTO = new DriverDTO();
        driverDTO.setId(66L);
        driverDTO.setMemberName("철가방 요리사");
        driverDTO.setMemberEmail("test@test.com");
        driverDTO.setMemberPassword("123456");
        driverDTO.setMemberPhoneNumber("testPhone");
        driverDTO.setMemberAddressCode("testCode");
        driverDTO.setMemberAddressBasic("testBasic");
        driverDTO.setMemberAddressDetail("testDetail");
        driverDTO.setDriverBank("testBank");
        driverDTO.setDriverBankAccount("testBankAccount");
        //지역 정보 등록
        driverDTO.setRegionIds(Arrays.asList(1L));

        driverService.registerDriver(driverDTO);
        log.info("DriverDTO: {}", driverDTO);
    }
}
