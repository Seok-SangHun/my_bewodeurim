package com.app.bewodeurim.service.pickup;

import com.app.bewodeurim.domain.member.MemberVO;
import com.app.bewodeurim.domain.pickup.Pagination;
import com.app.bewodeurim.domain.pickup.PickupDTO;
import com.app.bewodeurim.domain.pickup.PickupVO;
import com.app.bewodeurim.domain.plan.PlanVO;
import com.app.bewodeurim.repository.pickup.PickupDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Primary
@Transactional(rollbackFor = Exception.class)
public class PickupServiceImpl implements PickupService {
    private final PickupDAO pickupDAO;

    @Override
    public Optional<PlanVO> getPlan(Long id) {
        return pickupDAO.findByPlanID(id);
    }

    @Override
    public Optional<MemberVO> getMember(Long id) {
        return pickupDAO.findByMemberID(id);
    }

    @Override
    public void insertPickup(PickupVO pickupVO) {
        pickupDAO.save(pickupVO);
    }

    @Override
    public List<PickupDTO> getPickups(Pagination pagination, String order) {
        return pickupDAO.findAll(pagination, order);
    }

    @Override
    public Optional<PickupDTO> getPickup(Long id) {
        return pickupDAO.findById(id);
    }

    @Override
    public int getTotal() {
        return pickupDAO.getTotal();
    }

    @Override
    public void update(PickupVO pickupVO) {
        pickupDAO.setPickup(pickupVO);
    }
}
