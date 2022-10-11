package com.info.insurance;

public class ResidenceInsurance extends Insurance{
    @Override
    double calculate(Insurance insurance) {
        return insurance.getInsurancePrice()*5;
    }
}
