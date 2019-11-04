package Controller.impl;

import Controller.EmployeeController;
import Dao.Employees;
import Domain.EmployeeEntry;
import Domain.Response;
import Utils.BuildResponse;

/**
 * Created by Shubham Gupta on 24/08/19.
 */
public class EmployeeControllerImpl implements EmployeeController {

    private BuildResponse responseBuiler = new BuildResponse();

    public Response addEmployee(String name, String email, String mobile) {
        EmployeeEntry employeeEntry = new EmployeeEntry(name, email, mobile);
        Employees.addEmployee(employeeEntry);
        return responseBuiler.success();
    }
}
