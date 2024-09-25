package com.app.bewodeurim;

import com.app.bewodeurim.domain.member.MemberVO;
import com.app.bewodeurim.domain.pickup.Pagination;
import com.app.bewodeurim.domain.pickup.PickupDTO;
import com.app.bewodeurim.domain.plan.PlanVO;
import com.app.bewodeurim.mapper.pickup.PickupMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
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
            pickupDTO.setPickupSchedule("2024-09-25 10:00");
            pickupDTO.setPickupEnter("2024-09-25 09:00");
            pickupDTO.setPickupRequestContent("요청 내용"+i);
            pickupDTO.setPickupStatus("대기중");
            pickupMapper.insert(pickupDTO.toVO());
        }
    }

    @Test
    public void testSelectAll(){
        Pagination pagination = new Pagination();
        String order = "recent";
        pagination.setPage(3);
        pagination.setTotal(pickupMapper.selectTotal());
        pagination.progress();
        List<PickupDTO> posts = pickupMapper.selectAll(pagination, order);
        log.info("{}", posts.size());
        posts.stream().map(PickupDTO::toString).forEach(log::info);
    }

    @Test
    public void testSelectById() {
        Long id = 3L;
        Optional<PickupDTO> pickup = pickupMapper.selectById(id);
        pickup.ifPresent(dto -> log.info("Pickup: {}", dto));
    }

    @Test
    public void testSelectTotal() {
        int total = pickupMapper.selectTotal();
        log.info("Total Pickups: {}", total);
    }

    @Test
    public void testUpdate() {
        Long id = 3L; // 업데이트할 ID 설정
        Optional<PickupDTO> pickup = pickupMapper.selectById(id); // ID로 데이터 조회

        // 데이터를 조회하고 있을 경우 업데이트 진행
        pickup.ifPresent(dto -> {
            // 새로운 값으로 업데이트 (예: 요청 내용 수정)
            dto.setPickupRequestContent("업데이트 테스트");
            dto.setPickupEnter("true");  // 예시: 픽업 여부 업데이트
            dto.setPickupSchedule("2022-02-01");  // 픽업 일정을 2일 뒤로 설정
            dto.setPickupStatus("활동중");  // 상태 값을 변경 (예시로 '2' 설정)

            // DTO를 VO로 변환 후 업데이트 실행
            pickupMapper.update(dto.toVO());

            // 업데이트 결과 확인을 위한 로그 출력
            log.info("Pickup with ID {} updated successfully with new request content: {}",
                    id, dto.getPickupRequestContent());
        });
    }


}
