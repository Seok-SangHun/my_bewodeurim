package com.app.bewodeurim.domain.pickup;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class PickupVO {
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
}
