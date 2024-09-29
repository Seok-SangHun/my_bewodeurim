package com.app.bewodeurim.repository.driver;

import com.app.bewodeurim.domain.area.LikedAreaDTO;
import com.app.bewodeurim.domain.driver.DriverVO;
import com.app.bewodeurim.mapper.area.LikedAreaMapper;
import com.app.bewodeurim.mapper.driver.DriverMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Driver;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class DriverDAO {
    private final DriverMapper driverMapper;
    private final LikedAreaMapper likedAreaMapper;

    public void saveDriver(DriverVO driverVO) {driverMapper.insertDriverInfo(driverVO);}

    // 희망 지역 저장
    public void saveLikedAreas(List<LikedAreaDTO> likedAreas) {
        for (LikedAreaDTO likedArea : likedAreas) {
            likedAreaMapper.insertLikedArea(likedArea.toVO());
        }
    }
}
