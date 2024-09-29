package com.app.bewodeurim.driver;

import com.app.bewodeurim.domain.driver.DriverDTO;
import com.app.bewodeurim.mapper.driver.DriverMapper;
import com.app.bewodeurim.mapper.member.MemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class DriverMapperTest {
    @Autowired
    private DriverMapper driverMapper;
    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void insertest() {
        DriverDTO driverDTO = new DriverDTO();
//        기사정보만 테스트 했을때는 성공
        driverDTO.setId(30L);
       driverDTO.setDriverBank("농협");
       driverDTO.setDriverBankAccount("352-1234-5678-90");
       driverMapper.insertDriverInfo(driverDTO.toDriverVO());
    }
}
