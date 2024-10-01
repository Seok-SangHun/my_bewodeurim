package com.app.bewodeurim.domain.payment;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter @ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class PaymentVO {
    @EqualsAndHashCode.Include
    private Long id;
    private Long memberId;
    private Long planId;
    private int paymentPrice;
    private String paymentStatus;
    private String createdDate;
    private String updatedDate;



}
