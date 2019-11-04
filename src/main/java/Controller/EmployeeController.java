package Controller;

import Domain.Response;

/**
 * Created by Shubham Gupta on 24/08/19.
 */
public interface EmployeeController {

    Response addEmployee(String name, String email, String mobile);

}
