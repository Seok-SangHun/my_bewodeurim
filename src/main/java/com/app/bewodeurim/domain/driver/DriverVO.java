package com.app.bewodeurim.domain.driver;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class DriverVO {
    @EqualsAndHashCode.Include
    private Long id;
    private String driverBank;
    private String driverBankAccount;
    private String createdDate;
    private String updatedDate;


}
