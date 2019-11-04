package Domain;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Shubham Gupta on 24/08/19.
 */
@Data
@NoArgsConstructor
public class IncidentEntry {

    private Integer id;
    private String projectName;
    private String incident;

    public IncidentEntry(String projectName, String incident) {
        this.projectName = projectName;
        this.incident = incident;
    }

}
