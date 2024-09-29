package com.app.bewodeurim.service.driver;

import com.app.bewodeurim.domain.area.LikedAreaDTO;
import com.app.bewodeurim.domain.driver.DriverDTO;
import com.app.bewodeurim.domain.member.MemberVO;
import com.app.bewodeurim.repository.driver.DriverDAO;
import com.app.bewodeurim.repository.member.MemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class DriverServiceImpl implements DriverService {
    private final DriverDAO driverDAO;
    private final MemberDAO memberDAO;


    @Override
    public void registerDriver(DriverDTO driverDTO) {
        //driverDTO에 받은 정보중 일반회원 정보를 toMemberVO로 받는다
        MemberVO memberVO = driverDTO.toMemberVO();
        List<LikedAreaDTO> likedAreaDTOList = driverDTO.toLikedAreaDTOList();

        //일반회원 정보를 저장
        memberDAO.saveMember(memberVO);
        //일반회원에서 받아온 id를 기사회원DTO에 회원 아이디로 set
        driverDTO.setId(memberVO.getId());
        //기사회원 정보를 저장
        driverDAO.saveDriver(driverDTO.toDriverVO());

        // LikedArea 저장
        driverDAO.saveLikedAreas(likedAreaDTOList);

        // 지역 정보를 등록하는 로직
        //registerLikedAreas(driverDTO.getId(), driverDTO.getRegionIds());

//        @Override
//        public void registerLikedAreas(Long driverId, List<Long> regionIds) {
//            for (Long regionId : regionIds) {
//                LikedAreaDTO likedAreaDTO = new LikedAreaDTO();
//                likedAreaDTO.setDriverId(driverId);
//                likedAreaDTO.setRegionId(regionId);
//                likedAreaMapper.insertLikedArea(likedAreaDTO); // 지역 등록
//            }
//        }
    }


}
