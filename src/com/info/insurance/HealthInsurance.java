package com.info.insurance;

public class HealthInsurance extends Insurance{
    @Override
    double calculate(Insurance insurance) {
        return insurance.getInsurancePrice()*15;
    }
}
