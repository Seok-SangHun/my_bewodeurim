package com.app.bewodeurim.domain.plan;


import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Getter @Setter @ToString @EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class PlanVO implements Serializable {
    @EqualsAndHashCode.Include
    private Long id;
    private String grade;
    private int price;
    private String boxSize;
    private int maxMembers;
    private String status;
    private String createdDate;
    private String updatedDate;

}
