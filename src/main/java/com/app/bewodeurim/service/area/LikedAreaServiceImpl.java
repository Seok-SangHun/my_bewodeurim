package com.app.bewodeurim.service.area;

import com.app.bewodeurim.domain.area.LikedAreaDTO;
import com.app.bewodeurim.repository.area.LikedAreaDAO;
import com.app.bewodeurim.repository.driver.DriverDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Primary
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class LikedAreaServiceImpl implements LikedAreaService {
    private final LikedAreaDAO likedAreaDAO;
    private final DriverDAO driverDAO;

    @Override
    public void registerLikedAreas(Long driverId, List<Long> regionIds) {
        List<LikedAreaDTO> likedAreaDTOList = new ArrayList<>();
        for (Long regionId : regionIds) {
            likedAreaDTOList.add(new LikedAreaDTO(null, driverId, regionId));
        }
        driverDAO.saveLikedAreas(likedAreaDTOList); // LikedArea 저장
    }
}
