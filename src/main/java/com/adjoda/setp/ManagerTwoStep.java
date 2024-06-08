package com.adjoda.setp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(2)
@Slf4j
public class ManagerTwoStep implements CreditCardLimitIncreaseStep {
    private CreditCardLimitIncreaseStep nextStep;

    @Override
    public void execute(Integer expectedLimit) {
        if (expectedLimit > 10000 && nextStep != null) {
            nextStep.execute(expectedLimit);
        } else {
            log.info("Credit card limit increased by Manager Two");
        }
    }

    @Override
    public void setNextStep(CreditCardLimitIncreaseStep step) {
        this.nextStep = step;
    }
}