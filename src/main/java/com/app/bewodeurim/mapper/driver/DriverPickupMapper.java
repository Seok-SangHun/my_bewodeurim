package com.app.bewodeurim.mapper.driver;

import com.app.bewodeurim.domain.pickup.DriverPickUpDTO;
import com.app.bewodeurim.domain.pickup.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DriverPickupMapper {
    // 전체 조회
    public List<DriverPickUpDTO> selectAll(@Param("pagination") Pagination pagination, @Param("driverId") Long driverId);

//    전체 개수
    public int selectTotal();
}
