package com.adjoda.setp;

public interface CreditCardLimitIncreaseStep {
    void execute(Integer expectedLimit);
    void setNextStep(CreditCardLimitIncreaseStep step);
}