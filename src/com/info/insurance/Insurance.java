package com.info.insurance;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class Insurance {
    private SimpleDateFormat format = new SimpleDateFormat("yyyy");
    private String insuranceName;
    private double insurancePrice;
    private Date beginDate;
    private Date endDate;

    public Insurance() {
        this.setInsurancePrice(1250);
        this.setBeginDate(new Date(Calendar.getInstance().get(Calendar.YEAR)));
    }

    abstract double calculate();

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

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public SimpleDateFormat getFormat() {
        return format;
    }
}
