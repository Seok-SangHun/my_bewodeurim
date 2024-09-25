package com.app.bewodeurim.repository.pickup;

import com.app.bewodeurim.domain.member.MemberVO;
import com.app.bewodeurim.domain.pickup.Pagination;
import com.app.bewodeurim.domain.pickup.PickupDTO;
import com.app.bewodeurim.domain.pickup.PickupVO;
import com.app.bewodeurim.domain.plan.PlanVO;
import com.app.bewodeurim.mapper.pickup.PickupMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PickupDAO {
    private final PickupMapper pickupMapper;

    public Optional<PlanVO> findByPlanID(Long id){
        return pickupMapper.selectPlan(id);
    }

    public Optional<MemberVO> findByMemberID(Long id){
        return pickupMapper.selectMember(id);
    }

    public void save(PickupVO pickupVO){
        pickupMapper.insert(pickupVO);
    }

    public List<PickupDTO> findAll(Pagination pagination, String order){
        return pickupMapper.selectAll(pagination, order);
    }

    public Optional<PickupDTO> findById(Long id){
        return pickupMapper.selectById(id);
    }
    public int getTotal(){
        return pickupMapper.selectTotal();
    }
    public void setPickup(PickupVO pickupVO){
        pickupMapper.update(pickupVO);
    }
}
