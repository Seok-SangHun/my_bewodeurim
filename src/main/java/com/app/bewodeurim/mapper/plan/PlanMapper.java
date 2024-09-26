package com.app.bewodeurim.mapper.plan;

import com.app.bewodeurim.domain.plan.PlanVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PlanMapper {
    void findById(Long planId);
}
