package Dao;

import Domain.EmployeeEntry;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shubham Gupta on 24/08/19.
 */
@Data
public class Employees {

    private static List<EmployeeEntry> employee = new ArrayList<>();

    public static void addEmployee(EmployeeEntry employeeEntry){
        employee.add(employeeEntry);
    }

    public static List<EmployeeEntry> getAllEmployee(){
        return employee;

    }

    public static EmployeeEntry getEmployee(final String name){
        EmployeeEntry employeeEntry = employee.stream().filter(x -> x.getName().equalsIgnoreCase(name)).findFirst().get();
        return employeeEntry;
    }
}
