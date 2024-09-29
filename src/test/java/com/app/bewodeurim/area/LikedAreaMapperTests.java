package com.app.bewodeurim.area;

import com.app.bewodeurim.domain.area.LikedAreaDTO;
import com.app.bewodeurim.mapper.area.LikedAreaMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class LikedAreaMapperTests {
    @Autowired
    private LikedAreaMapper likedAreaMapper;

    @Test
    public void InsertLikedAreaTest() {
        LikedAreaDTO likedAreaDTO = new LikedAreaDTO();
        likedAreaDTO.setDriverId(56L);
        likedAreaDTO.setRegionId(1L);
        likedAreaMapper.insertLikedArea(likedAreaDTO.toVO());
    }
}
