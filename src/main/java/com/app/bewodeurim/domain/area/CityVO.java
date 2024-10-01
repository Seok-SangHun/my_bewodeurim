package com.app.bewodeurim.domain.area;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
@Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class CityVO {
    private Long id;
    private String cityName;

}
