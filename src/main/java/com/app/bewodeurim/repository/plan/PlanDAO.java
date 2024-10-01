package com.app.bewodeurim.repository.plan;

import com.app.bewodeurim.domain.plan.PlanVO;
import com.app.bewodeurim.mapper.plan.PlanMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PlanDAO {
    private final PlanMapper planMapper;

    public PlanVO findById(Long planId) {
        return planMapper.findById(planId);
    }

    public List<PlanVO> findAllPlans() {
        return planMapper.findAllPlans();  // 모든 요금제 가져오기
    }
}
