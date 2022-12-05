package com.camargovf.hrpayroll.services;

import com.camargovf.hrpayroll.entities.Payment;
import com.camargovf.hrpayroll.entities.Worker;
import com.camargovf.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workerId, int days) {

       Worker worker = workerFeignClient.findById(workerId).getBody(); //ResponseEntity getBody
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
