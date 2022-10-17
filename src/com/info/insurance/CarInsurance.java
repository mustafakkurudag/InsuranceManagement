package com.info.insurance;

import java.util.Calendar;
import java.util.Date;

public class CarInsurance extends Insurance {

    public CarInsurance() {
        this.setInsuranceName("Araç Sigortası");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, 1);
        this.setEndDate(calendar.getTime());
    }

    @Override
    public double calculate() {
        return getInsurancePrice()*15;
    }
}
