package com.app.bewodeurim.mapper.pickup;

import com.app.bewodeurim.domain.member.MemberVO;
import com.app.bewodeurim.domain.pickup.DriverPickUpDTO;
import com.app.bewodeurim.domain.pickup.Pagination;
import com.app.bewodeurim.domain.pickup.PickupDTO;
import com.app.bewodeurim.domain.pickup.PickupVO;
import com.app.bewodeurim.domain.plan.PlanVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PickupMapper {
    public void insert(PickupVO pickupVO);
    public List<PickupDTO> selectAll(@Param("pagination") Pagination pagination, @Param("order") String order);
    public List<PickupDTO> mySelectAll(@Param("pagination") Pagination pagination, @Param("order") String order, @Param("driverId") Long driverId);
    public Optional<PickupDTO> selectById(Long id);
    public int selectTotal();
    public int mySelectTotal();
    public void update(PickupVO pickupVO);
}
