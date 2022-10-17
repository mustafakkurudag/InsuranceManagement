package com.info.insurance;

import java.util.Calendar;
import java.util.Date;

public class TravelInsurance extends Insurance {
    public TravelInsurance() {
        this.setInsuranceName("Seyahat Sigortası");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, 3);
        this.setEndDate(calendar.getTime());
    }

    @Override
    public double calculate() {
        return getInsurancePrice()*20;
    }
}
