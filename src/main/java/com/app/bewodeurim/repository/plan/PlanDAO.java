package com.app.bewodeurim.repository.plan;

import com.app.bewodeurim.domain.plan.PlanVO;
import com.app.bewodeurim.mapper.plan.PlanMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PlanDAO {
    private final PlanMapper planMapper;

    public PlanVO findById(Long planId) {
        return planMapper.findById(planId);
    }
}

