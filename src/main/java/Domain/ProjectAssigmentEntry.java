package Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Shubham Gupta on 24/08/19.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectAssigmentEntry {

    private String project;
    private String employee_name;
    private Integer level;

    public ProjectAssigmentEntry(String project, String employee_name) {
        this.project = project;
        this.employee_name = employee_name;
    }
}
