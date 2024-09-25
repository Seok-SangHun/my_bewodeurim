package com.app.bewodeurim.service.pickup;

import com.app.bewodeurim.domain.member.MemberVO;
import com.app.bewodeurim.domain.pickup.Pagination;
import com.app.bewodeurim.domain.pickup.PickupDTO;
import com.app.bewodeurim.domain.pickup.PickupVO;
import com.app.bewodeurim.domain.plan.PlanVO;

import java.util.List;
import java.util.Optional;

public interface PickupService {
    public Optional<PlanVO> getPlan(Long id);
    public Optional<MemberVO> getMember(Long id);
    public void insertPickup(PickupVO pickupVO);
    public List<PickupDTO> getPickups(Pagination pagination, String order);
    public Optional<PickupDTO> getPickup(Long id);
    public int getTotal();
    public void update(PickupVO pickupVO);
}
