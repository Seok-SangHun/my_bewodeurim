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

    public PickupVO toVO(){
        return new PickupVO(id,pickupNumber,memberId,driverId,pickupSchedule,pickupEnter,pickupRequestContent,pickupStatus,createdDate,updatedDate);
    }
}
