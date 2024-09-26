package com.app.bewodeurim.driver;

import com.app.bewodeurim.domain.driver.DriverDTO;
import com.app.bewodeurim.service.driver.DriverService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class DriverServiceTests {
    @Autowired
    private DriverService driverService;

    @Test
    public void testRegisterDriver() {
        DriverDTO driverDTO = new DriverDTO();
        driverDTO.setId(30L);
        driverDTO.setMemberName("test");
        driverDTO.setMemberEmail("test@test.com");
        driverDTO.setMemberPassword("123456");
        driverDTO.setMemberPhoneNumber("testPhone");
        driverDTO.setMemberAddressCode("testCode");
        driverDTO.setMemberAddressBasic("testBasic");
        driverDTO.setMemberAddressDetail("testDetail");
        driverDTO.setDriverBank("testBank");
        driverDTO.setDriverBankAccount("testBankAccount");

        driverService.registerDriver(driverDTO);
        log.info("DriverDTO: {}", driverDTO);
    }
}
