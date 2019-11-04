package Domain;

import lombok.Data;

/**
 * Created by Shubham Gupta on 24/08/19.
 */
@Data
public class Response {

    private Status status;
    private String message;
    private Integer id;
    private EmployeeEntry employeeEntry;
}
