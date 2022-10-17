package com.info.insurance;

import java.util.Calendar;
import java.util.Date;

public class HealthInsurance extends Insurance{
    public HealthInsurance() {
        this.setInsuranceName("Sağlık Sigortası");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, 4);
        this.setEndDate(calendar.getTime());
    }
    @Override
    double calculate() {
        return getInsurancePrice()*15;
    }
}
