package com.info.insurance;

import java.util.Date;

public abstract class Insurance {
    private String insuranceName;
    private double insurancePrice;
    private Date beginDate;
    private Date endDate;

    abstract double calculate(Insurance insurance);

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public double getInsurancePrice() {
        return insurancePrice;
    }

    public void setInsurancePrice(double insurancePrice) {
        this.insurancePrice = insurancePrice;
    }
}
