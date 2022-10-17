package com.info.insurance;

import java.util.Calendar;
import java.util.Date;

public class ResidenceInsurance extends Insurance{
    public ResidenceInsurance() {
        this.setInsuranceName("Konut Sigortası");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, 2);
        this.setEndDate(calendar.getTime());
    }

    @Override
    public double calculate() {
        return getInsurancePrice()*5;
    }
}
