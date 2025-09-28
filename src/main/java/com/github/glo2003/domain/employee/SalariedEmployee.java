package com.github.glo2003.domain.employee;

public class SalariedEmployee extends Employee {
    private float biweekly;

    public SalariedEmployee(String name, String role, int vacation_days, float biweekly) {
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
    public String toString() {
        return "SalariedEmployee{" +
                "name='" + this.getName() + '\'' +
                ", role='" + this.getRole() + '\'' +
                ", vacation_days=" + this.getVacationDays() +
                ", monthly=" + biweekly +
                '}';
    }
}
