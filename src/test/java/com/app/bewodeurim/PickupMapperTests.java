package com.app.bewodeurim;

import com.app.bewodeurim.domain.pickup.PickupDTO;
import com.app.bewodeurim.mapper.pickup.PickupMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
@Slf4j
public class PickupMapperTests {
    @Autowired
    private PickupMapper pickupMapper;

    @Test
    public void testInsert() {
        PickupDTO pickupDTO = new PickupDTO();
        for(int i=0; i<34; i++) {
            pickupDTO.setPickupNumber("PICKUP"+i);
            pickupDTO.setMemberId(1L); // 실제 회원 ID로 설정
            pickupDTO.setDriverId(1L); // 실제 운전사 ID로 설정
            pickupDTO.setPickupSchedule("2024-09-25 10:00");
            pickupDTO.setPickupEnter("2024-09-25 09:00");
            pickupDTO.setPickupRequestContent("요청 내용"+i);
            pickupDTO.setPickupStatus("대기중");
            pickupMapper.insert(pickupDTO.toVO());
        }
    }
}
