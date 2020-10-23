package org.example.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.cloud.entities.CommonResult;
import org.example.cloud.entities.Payment;
import org.example.cloud.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****result:: --->  "+result);
        if (result > 0) {
            return new CommonResult(200,"success",result);
        } else {
            return new CommonResult(444,"fail",null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****result:: --->  "+payment);
        if (payment != null) {
            return new CommonResult(200,"get--success",payment);
        } else {
            return new CommonResult(444,"get--fail-->id: "+id,null);
        }
    }
}
