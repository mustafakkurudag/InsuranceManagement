package com.info.insurance;

public class TravelInsurance extends Insurance {
    public TravelInsurance() {
        this.setInsuranceName("Seyahat Sigortası");
    }

    @Override
    double calculate(Insurance insurance) {
        return insurance.getInsurancePrice()*20;
    }
}
