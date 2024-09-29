package com.app.bewodeurim.mapper.plan;

import com.app.bewodeurim.domain.plan.PlanVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlanMapper {
    PlanVO findById(Long planId);  // 요금제 ID로 요금제 조회
    List<PlanVO> findAllPlans();  // 모든 요금제 조회
}
