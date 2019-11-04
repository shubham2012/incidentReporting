package Domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Shubham Gupta on 24/08/19.
 */
@Data
@AllArgsConstructor
public class EmployeeEntry {

    private String name;
    private String email;
    private String phoneNumber;
}
