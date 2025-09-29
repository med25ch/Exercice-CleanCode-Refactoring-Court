package com.github.glo2003.domain.employee;


import com.github.glo2003.domain.paycheck.Paycheck;

public abstract class Employee {
    private final String name;
    private final Role role;
    private int vacationDays;
    private boolean isInVacation;

    public Employee(String name, Role role, int vacation_days) {
        this.name = name;
        this.role = role;
        this.isInVacation = false;
        this.vacationDays = vacation_days;
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    public boolean isInVacation() {
        return isInVacation;
    }

    public void setInVacation(boolean inVacation) {
        isInVacation = inVacation;
    }

    public int getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(int vacation_days) {
        this.vacationDays = vacation_days;
    }

    public abstract Paycheck createPaycheck();
    public abstract void setPayRise(float rise);

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", vacation_days=" + vacationDays +
                '}';
    }
}
