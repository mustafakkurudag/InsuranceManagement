package com.info.insurance;

public class CarInsurance extends Insurance {
    @Override
    double calculate(Insurance insurance) {
        return insurance.getInsurancePrice()*10;
    }
}
