package org.example.cloud.service;

import org.apache.ibatis.annotations.Param;
import org.example.cloud.entities.Payment;

public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id")Long id);

}
