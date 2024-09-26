package com.app.bewodeurim.mapper.area;

import com.app.bewodeurim.domain.area.CityVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CityMapper {
    public void insertCity(CityVO cityVO);
}
