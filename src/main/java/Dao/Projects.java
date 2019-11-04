package Dao;

import Domain.ProjectEntry;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shubham Gupta on 24/08/19.
 */
@Data
public class Projects {

    private static List<ProjectEntry> projects = new ArrayList<>();

    public static void addProject(ProjectEntry projectEntry){
        projects.add(projectEntry);
    }


    public static List<ProjectEntry> getAllProjects(){
        return projects;
    }
}
