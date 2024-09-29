package com.app.bewodeurim.area;

import com.app.bewodeurim.domain.area.RegionDTO;
import com.app.bewodeurim.mapper.area.RegionMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class RegionMapperTests {
    @Autowired
    private RegionMapper regionMapper;

    @Test
    public void testInsertRegion() {
        RegionDTO regionDTO = new RegionDTO();
        regionDTO.setCityId(1L);
        regionDTO.setRegionName("금천구");

        regionMapper.insertRegion(regionDTO.toRegionVO());
    }
}
