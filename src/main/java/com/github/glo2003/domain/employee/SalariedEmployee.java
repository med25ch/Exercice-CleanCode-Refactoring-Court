package com.github.glo2003.domain.employee;

import com.github.glo2003.domain.paycheck.Paycheck;

public class SalariedEmployee extends Employee {
    private float biweekly;

    public SalariedEmployee(String name, Role role, int vacation_days, float biweekly) {
        super(name, role, vacation_days);
        this.biweekly = biweekly;
    }

    public float getBiweekly() {
        return biweekly;
    }

    public void setBiweekly(float biweekly) {
        this.biweekly = biweekly;
    }

    @Override
    public Paycheck createPaycheck() {
        return new Paycheck(getName(), this.biweekly);
    }

    @Override
    public void setPayRise(float raise) {
        setBiweekly(this.biweekly + raise);
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" +
                "name='" + this.getName() + '\'' +
                ", role='" + this.getRole() + '\'' +
                ", vacation_days=" + this.getVacationDays() +
                ", monthly=" + biweekly +
                '}';
    }
}
