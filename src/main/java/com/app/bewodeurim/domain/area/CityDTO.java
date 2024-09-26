package com.app.bewodeurim.domain.area;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter @ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CityDTO {
    @EqualsAndHashCode.Include
    private Long id;
    private String cityName;


    public CityVO toVO() {
        return new CityVO(id, cityName);
    }
}
