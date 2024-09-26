package com.app.bewodeurim.domain.area;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter  @ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class RegionDTO {
    private Long id;
    private String cityName;
    private String regionName;

    public RegionVO toVO() {
        return new RegionVO(id, cityName, regionName);
    }
}
