package com.app.bewodeurim.service.plan;

import com.app.bewodeurim.domain.plan.PlanVO;
import com.app.bewodeurim.repository.plan.PlanDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
@Transactional(readOnly = true)
public class PlanServiceImpl implements PlanService {
    private final PlanDAO planDAO;

    @Override
    public PlanVO getPlanById(Long planId) {
        return planDAO.findById(planId);
    }

    @Override
    public List<PlanVO> getAllPlans() {
        return planDAO.findAllPlans();  // PlanDAO에서 모든 요금제 가져오는 메소드 호출
    }


}
