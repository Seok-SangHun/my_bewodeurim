package com.app.bewodeurim.repository.pickup;

import com.app.bewodeurim.domain.pickup.DriverPickUpDTO;
import com.app.bewodeurim.domain.pickup.Pagination;
import com.app.bewodeurim.mapper.driver.DriverPickupMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DriverPickupDAO {
    private final DriverPickupMapper driverPickupMapper;

//    기사 담당 수거 목록 전체 조회
    public List<DriverPickUpDTO> findAllByDriverId(Pagination pagination, Long driverId){
        return driverPickupMapper.selectAll(pagination, driverId);
    }

//    목록 전체 개수
    public int findCount(){
        return driverPickupMapper.selectTotal();
    }
}
