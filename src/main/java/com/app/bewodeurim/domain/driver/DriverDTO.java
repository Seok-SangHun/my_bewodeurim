package com.app.bewodeurim.domain.driver;

import com.app.bewodeurim.domain.area.*;
import com.app.bewodeurim.domain.member.MemberVO;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
@ToString
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class DriverDTO {
    @EqualsAndHashCode.Include
    private Long id;
    private String memberName;
    private String memberEmail;
    private String memberPassword;
    private String memberPhoneNumber;
    private String memberAddressCode;
    private String memberAddressBasic;
    private String memberAddressDetail;
    private String memberStatus;
    private String memberType;
    private String driverBank;
    private String driverBankAccount;
    private String createdDate;
    private String updatedDate;
    // 선택한 지역 ID 목록
    private List<Long> regionIds;

//    private List<CityDTO> cityId;
//    //    화면에서 받을 값
//    private List<CityDTO> cityName;
//    //likedArea 테이블에서 필요한 값
//    private List<RegionDTO> regionId;
//    //    화면에서 받을 값
//    private List<RegionDTO> regionName;

//    public LikedAreaVO toLikedAreaVO() {
//        LikedAreaVO(id,DriverId,regionId)
//        DriverId는 driverDTO에서 id이다.
//        return new LikedAreaVO(id,driverId,regionId);
//    }


    public DriverVO toDriverVO() {
        return new DriverVO(id, driverBank, driverBankAccount, createdDate, updatedDate);
    }

    public MemberVO toMemberVO() {
        return new MemberVO(id,memberName,memberEmail,memberAddressCode,memberAddressBasic
        ,memberAddressDetail,memberPhoneNumber,memberStatus,memberType,memberPassword,createdDate,updatedDate);
    }

    // LikedAreaDTO 목록으로 변환하는 메서드
    //지역들.forEach((지역) -> { insert(지역); });
    public List<LikedAreaDTO> toLikedAreaDTOList() {
        //선택한 지역들을 담을 리스트 생성
        List<LikedAreaDTO> likedAreaDTOList = new ArrayList<>();
        //아이디들을 리스트에 저장
        if (regionIds != null) { // null 체크 추가
            regionIds.forEach(regionId ->
                    likedAreaDTOList.add(new LikedAreaDTO(null, this.id, regionId))
            );
        }
        return likedAreaDTOList;
    }
}
