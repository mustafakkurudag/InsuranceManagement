package com.info.insurance;

import java.util.Date;

public abstract class Insurance {
    private String insuranceName;
    private double insurancePrice;
    private Date beginDate;
    private Date endDate;

    abstract double calculate(Insurance insurance);
}
