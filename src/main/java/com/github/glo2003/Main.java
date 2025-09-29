package com.github.glo2003;

import com.github.glo2003.domain.employee.Role;
import com.github.glo2003.service.CompanyPayroll;
import com.github.glo2003.domain.employee.Employee;
import com.github.glo2003.domain.employee.HourlyEmployee;
import com.github.glo2003.domain.employee.SalariedEmployee;

public class Main {

    public static void main(String[] args) {
        CompanyPayroll companyPayroll = new CompanyPayroll();

        Employee e1 = new HourlyEmployee("Alice", Role.VP, 25, 100, 35.5f * 4);
        Employee e2 = new SalariedEmployee("Bob", Role.ENGINEER, 4, 1500);
        Employee e3 = new SalariedEmployee("Charlie", Role.MANAGER, 4, 2000);
        Employee e4 = new HourlyEmployee("Ernest", Role.INTERN, 1, 5, 50 * 4);
        Employee e5 = new HourlyEmployee("Fred", Role.INTERN, 1, 5, 50 * 4);

        companyPayroll.addEmp(e1);
        companyPayroll.addEmp(e2);
        companyPayroll.addEmp(e3);
        companyPayroll.addEmp(e4);
        companyPayroll.addEmp(e5);

        System.out.println("----- Listing employees -----");
        companyPayroll.findEmployeesByRole(Role.VP).forEach(System.out::println);
        companyPayroll.findEmployeesByRole(Role.MANAGER).forEach(System.out::println);
        companyPayroll.findEmployeesByRole(Role.ENGINEER).forEach(System.out::println);
        companyPayroll.findEmployeesByRole(Role.INTERN).forEach(System.out::println);

        System.out.println("----- Giving raises -----");
        companyPayroll.salaryRaise(e1, 10);
        companyPayroll.salaryRaise(e2, 100);

        System.out.println("\n----- Create paychecks -----");
        companyPayroll.createPending();

        System.out.println("\n----- Pay statistics -----");
        float t = companyPayroll.getTotalmoney();
        System.out.println("Total money spent: ");
        float avg = companyPayroll.avgPayCehck_pending();
        System.out.println("Average paycheck: " + avg);

        System.out.println("\n----- Pay -----");
        companyPayroll.processPending();
    }
}
