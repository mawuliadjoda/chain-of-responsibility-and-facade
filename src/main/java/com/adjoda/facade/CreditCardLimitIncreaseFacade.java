package com.adjoda.facade;

import com.adjoda.setp.CreditCardLimitIncreaseStep;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardLimitIncreaseFacade {

    private CreditCardLimitIncreaseStep
            firstStep;

    public CreditCardLimitIncreaseFacade(List<CreditCardLimitIncreaseStep> steps) {
        firstStep = steps.get(0);
        for (int i = 0; i < steps.size(); i++) {
            var current = steps.get(i);
            var next = i < steps.size() - 1 ? steps.get(i + 1) : null;
            current.setNextStep(next);
        }
    }

    public void increaseCreditCardLimit(Integer expectedLimit) {
        firstStep.execute(expectedLimit);
    }
}