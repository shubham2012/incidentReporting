package Domain;

import lombok.Data;

/**
 * Created by Shubham Gupta on 24/08/19.
 */
@Data
public class IncidentAssigmentEntry {
    private Integer incident;
    private EmployeeEntry employeeEntry;
    private boolean ack;
    private Integer level;
}
