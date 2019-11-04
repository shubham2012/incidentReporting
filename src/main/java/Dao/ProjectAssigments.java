package Dao;

import Domain.ProjectAssigmentEntry;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shubham Gupta on 24/08/19.
 */
@Data
public class ProjectAssigments {

    private static List<ProjectAssigmentEntry> projectAssigment = new ArrayList<>();

    public static void assignProject(ProjectAssigmentEntry projectAssigmentEntry){
        projectAssigment.add(projectAssigmentEntry);
    }

    public static List<ProjectAssigmentEntry> getAllProjectAssigments(){
        return projectAssigment;
    }

    public static ProjectAssigmentEntry getAssigment(String project, String employee){
        return projectAssigment.stream()
                .filter(x->x.getProject().equalsIgnoreCase(project) && x.getEmployee_name().equalsIgnoreCase(employee))
                .findFirst().get();
    }
}
