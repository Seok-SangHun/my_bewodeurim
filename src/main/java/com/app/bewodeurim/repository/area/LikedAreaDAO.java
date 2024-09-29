package com.app.bewodeurim.repository.area;

import com.app.bewodeurim.domain.area.LikedAreaDTO;
import com.app.bewodeurim.mapper.area.LikedAreaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LikedAreaDAO {
    private final LikedAreaMapper likedAreaMapper;
    // 희망 지역 저장
    public void saveLikedAreas(List<LikedAreaDTO> likedAreas) {
        for (LikedAreaDTO likedArea : likedAreas) {
            likedAreaMapper.insertLikedArea(likedArea.toVO());
        }
    }
}
