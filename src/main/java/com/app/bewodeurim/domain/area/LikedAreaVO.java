package com.app.bewodeurim.domain.area;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class LikedAreaVO {
    private Long id;
    private Long driverId;
    private Long regionId;
}
