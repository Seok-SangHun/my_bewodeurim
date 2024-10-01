package com.app.bewodeurim.mapper.area;

import com.app.bewodeurim.domain.area.LikedAreaVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LikedAreaMapper {

    public void insertLikedArea(LikedAreaVO likedAreaVO);
}
