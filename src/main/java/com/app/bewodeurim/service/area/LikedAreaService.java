package com.app.bewodeurim.service.area;

import java.util.List;

public interface LikedAreaService {
    void registerLikedAreas(Long driverId, List<Long> regionIds); // 추가
}
