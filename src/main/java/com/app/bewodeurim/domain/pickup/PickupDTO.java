package com.app.bewodeurim.domain.pickup;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@ToString
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class PickupDTO {
    @EqualsAndHashCode.Include
    private Long id;
    private String pickupNumber;
    private Long memberId;
    private Long driverId;
    private String pickupSchedule;
    private String pickupEnter;
    private String pickupRequestContent;
    private String pickupStatus;
    private String createdDate;
    private String updatedDate;
    private String memberAddressCode;
    private String memberAddressBasic;
    private String memberAddressDetail;
    private int planPrice;
    private String planGrade;
    private String planBoxSize;
    private int planDeliveryFee;
    private int planMaxMembers;

    public PickupVO toVO(){
        return new PickupVO(id,pickupNumber,memberId,driverId,pickupSchedule,pickupEnter,pickupRequestContent,pickupStatus,createdDate,updatedDate);
    }
}
