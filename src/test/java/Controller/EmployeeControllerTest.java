package Controller;

import Controller.impl.EmployeeControllerImpl;
import Dao.Employees;
import Domain.Response;
import org.junit.jupiter.api.Test;

/**
 * Created by Shubham Gupta on 24/08/19.
 */
class EmployeeControllerTest {
    private EmployeeControllerImpl controller = new EmployeeControllerImpl();

    @Test
    void createEmployeeTest() {

        Response response = controller.addEmployee("test", "xyz@gmail.com", "9988776655");
        System.out.println(response);
        System.out.println(Employees.getAllEmployee());
    }
}