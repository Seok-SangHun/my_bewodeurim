package com.app.bewodeurim.domain.pickup;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Getter @EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class DriverPickUpVO {
    @EqualsAndHashCode.Include
    private Long id;
    private Long memberId;
    private Long driverId;
    private String createdDate;
    private String updatedDate;
}
