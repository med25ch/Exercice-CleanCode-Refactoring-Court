package com.github.glo2003.domain.paycheck;

public class Paycheck {
    private final String employeeName;
    private final float amount;

    public Paycheck(String to, float amount) {
        this.employeeName = to;
        this.amount = amount;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public float getAmount() {
        return amount;
    }
}
