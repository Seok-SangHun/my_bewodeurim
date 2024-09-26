package com.app.bewodeurim.domain.area;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter @ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class LikedAreaDTO {
    private Long id;
    private Long driverId;
    private Long regionId;

    public LikedAreaVO toVO() {
        return new LikedAreaVO(id, driverId, regionId);
    }
}
