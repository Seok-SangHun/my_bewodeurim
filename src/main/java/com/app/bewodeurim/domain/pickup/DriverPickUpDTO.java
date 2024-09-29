package com.app.bewodeurim.domain.pickup;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DriverPickUpDTO {
    @EqualsAndHashCode.Include
    private Long id;
    private Long memberId;
    private Long driverId;
    private String createdDate;
    private String updatedDate;

    public DriverPickUpVO toVO(){
        return new DriverPickUpVO(id, memberId, driverId, createdDate, updatedDate);
    }
}
