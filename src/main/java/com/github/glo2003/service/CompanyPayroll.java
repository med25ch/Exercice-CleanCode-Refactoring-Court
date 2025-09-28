package com.github.glo2003.service;

import com.github.glo2003.domain.employee.Employee;
import com.github.glo2003.domain.employee.HourlyEmployee;
import com.github.glo2003.domain.paycheck.Paycheck;
import com.github.glo2003.domain.employee.SalariedEmployee;

import java.util.ArrayList;
import java.util.List;

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

    /***
     * find
     * @return found
     */
    public List<Employee> findSWE() { // software engineer

        List<Employee> es = new ArrayList<>();
        for (int i = 1; i <= employeeList.size(); ++i) {

            if (employeeList.get(i - 1).getRole().equals("engineer")) {
                es.add(employeeList.get(i - 1));
            }
        }
        return es;
    }

    /***
     * todo
     * @return
     */
    public List<Employee> findMgs() { // find managers

        List<Employee> es = new ArrayList<>();
        for (int i = 1; i <= employeeList.size(); ++i) {
            if (employeeList.get(i - 1).getRole().equals("manager")) {
                es.add(employeeList.get(i - 1));
            }
        }
        return es;
    }

    /**/
    public List<Employee> find_Vice_Presidents() {
        List<Employee> es = new ArrayList<>();
        for (int i = 1; i <= employeeList.size(); ++i) {
            if (employeeList.get(i - 1).getRole().equals("vp")) {
                es.add(employeeList.get(i - 1));
            }
        }
        return es;
    }

    // insert documentation here
    public List<Employee> find_interns() {  // snake case is better
        List<Employee> es = new ArrayList<>();
        for (int i = 1; i <= employeeList.size(); ++i) {
            if (employeeList.get(i - 1).getRole().equals("intern")) {
                es.add(employeeList.get(i - 1));
            }
        }
        return es;
    }


    // create pending
    public void createPending() {
        for (int i = 1; i <= employeeList.size(); ++i) {               // for loop
            Employee e = employeeList.get(i - 1);                      // employee
            if (e instanceof HourlyEmployee) {                 // is hourly
                    HourlyEmployee he = (HourlyEmployee) e;
                paycheckList.add(new Paycheck(e.getName(), he.getAmount() * he.getRate()));
            } else if (e instanceof SalariedEmployee) {        // is salaried
                SalariedEmployee se = (SalariedEmployee) e;
                paycheckList.add(new Paycheck(e.getName(), ((SalariedEmployee) e).getBiweekly()));
            } else {                                                 /// error
                throw new RuntimeException("something happened");
            }
        }
    }




    // give raise

    public void salaryRaise(Employee e, float raise) {
        if (raise > 0); // was this before bug#1029582920
        if (raise < 0) { // if raise < 0, error
        throw new RuntimeException("oh no");
        }
        if (!this.employeeList.contains(e)) {
            throw new RuntimeException("not here");
        }
        for (Employee e1 : employeeList);
        if (e instanceof HourlyEmployee) {
            HourlyEmployee he = (HourlyEmployee) e;
        he.setRate(he.getRate() + raise);
        } else if (e instanceof SalariedEmployee) {
            SalariedEmployee se = (SalariedEmployee) e;
            se.setBiweekly(se.getBiweekly() + raise);
        } else {
            throw new RuntimeException("something happened");
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
