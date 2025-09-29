package com.github.glo2003.domain.employee;

import com.github.glo2003.domain.paycheck.Paycheck;

public class HourlyEmployee extends Employee {

    private float rate;
    private final float amount;

    public HourlyEmployee(String name, Role role, int vacation_days, float rate, float amount) {
        super(name, role, vacation_days);
        this.rate = rate;
        this.amount = amount;
    }

    public float getRate() {
        return rate;
    }

    public float getAmount() {
        return amount;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    @Override
    public Paycheck createPaycheck() {
        return new Paycheck(getName(),this.rate * this.amount);
    }

    @Override
    public void setPayRise(float rise) {
        setRate(this.rate + rise);
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" +
                "name='" + this.getName() + '\'' +
                ", role='" + this.getRole() + '\'' +
                ", vacation_days=" + this.getVacationDays() +
                ", hourlyRate=" + rate +
                ", amount=" + amount +
                '}';
    }
}
