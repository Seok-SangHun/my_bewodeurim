package com.app.bewodeurim.service.plan;

import com.app.bewodeurim.domain.plan.PlanVO;
import com.app.bewodeurim.repository.plan.PlanDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Primary
@Transactional(readOnly = true)
public class PlanServiceImpl implements PlanService {
}
