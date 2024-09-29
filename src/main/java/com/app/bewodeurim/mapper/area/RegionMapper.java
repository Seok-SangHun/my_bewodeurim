package com.app.bewodeurim.mapper.area;

import com.app.bewodeurim.domain.area.RegionVO;
import org.apache.ibatis.annotations.Mapper;

import javax.swing.plaf.synth.Region;
@Mapper
public interface RegionMapper {

    public void insertRegion(RegionVO regionVO);
}
