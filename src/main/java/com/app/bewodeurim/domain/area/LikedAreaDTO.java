package com.app.bewodeurim.domain.area;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter @ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class LikedAreaDTO {
    private Long id;
    private Long driverId;
    private Long regionId;

    public LikedAreaVO toVO() {
        return new LikedAreaVO(id, driverId, regionId);
    }
}
