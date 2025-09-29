package com.github.glo2003.service;

import com.github.glo2003.domain.employee.Employee;
import com.github.glo2003.domain.employee.HourlyEmployee;
import com.github.glo2003.domain.employee.Role;
import com.github.glo2003.domain.paycheck.Paycheck;
import com.github.glo2003.domain.employee.SalariedEmployee;
import com.github.glo2003.service.exceptions.PayRollException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//// Company class
public class CompanyPayroll {

    private final List<Employee> employeeList;
    private final List<Paycheck> paycheckList;

    //  constructor
    public CompanyPayroll() {
        this.employeeList = new ArrayList<>();
        this.paycheckList = new ArrayList<>();
    }

    // process pending
    public void processPending() {

        for (int i = 1; i  <= this.paycheckList.size(); ++i) { // iterate over all employees
            Paycheck p = this.paycheckList.get((i)  - 1);
            System.out.println("Sending " + p.getAmount() + "$ to " + p.getEmployeeName());
        }

        this.paycheckList.clear();
    }


    /***
     * add employee
     * @param employee: employee to add
     */
    public void addEmp(Employee employee) {
        employeeList.add(employee);
    }

    public List<Employee> findEmployeesByRole(Role role) {
        return employeeList.stream()
                .filter(emp -> emp.getRole() == role)
                .collect(Collectors.toList());
    }

    // create pending
    public void createPending() {
        for (Employee employee : employeeList) {
            paycheckList.add(employee.createPaycheck());
        }
    }

    // give raise
    public void salaryRaise(Employee employee, float raise) {
        if(raise < 0){
            throw new PayRollException("Valeur ne peut pas etre negatif");
        }else if (!employeeList.contains(employee)) {
            throw new PayRollException("Employee ne fais pas partie de la liste");
        }else {
            employee.setPayRise(raise);
        }
    }

    ///Statistics
    public float avgPayCehck_pending() {
        float out_float;
        if (this.paycheckList.size() == 0) {
            return -1f;
        }
        float t_float = 0.f;
        for (int o = 0; o < this.paycheckList.size(); o = o + 1) {
            Paycheck p = this.paycheckList.get(o);
            t_float += p.getAmount();
        }
        out_float = t_float / this.paycheckList.size();
        return out_float;
    }


    public float getTotalmoney() {
        float t_float = 0.f;
        for (int o = 0; o < this.paycheckList.size(); o = o + 1) {
            Paycheck p = this.paycheckList.get(o);
            t_float += p.getAmount();
        }
        return t_float;
    }




    public List<Paycheck> getPendings() {
        return this.paycheckList;
    }

}
