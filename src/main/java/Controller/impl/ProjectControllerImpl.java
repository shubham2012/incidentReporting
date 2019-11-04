package Controller.impl;

import Controller.ProjectController;
import Dao.Employees;
import Dao.ProjectAssigments;
import Dao.Projects;
import Domain.EmployeeEntry;
import Domain.ProjectAssigmentEntry;
import Domain.ProjectEntry;
import Domain.Response;
import Utils.BuildResponse;

import java.util.Objects;

/**
 * Created by Shubham Gupta on 24/08/19.
 */
public class ProjectControllerImpl implements ProjectController {

    private BuildResponse responseBuiler = new BuildResponse();

    @Override
    public Response addProject(String name) {
        ProjectEntry projectEntry = new ProjectEntry(name);
        Projects.addProject(projectEntry);
        return responseBuiler.success();
    }

    @Override
    public Response assignProject(String project, String employee) {
        ProjectAssigmentEntry entry = new ProjectAssigmentEntry(project, employee);

        //TODO : validate if employee and project exists

        ProjectAssigments.assignProject(entry);
        return responseBuiler.success();
    }

    @Override
    public Response setLevel(String project, String employee, Integer level) {

        //TODO : validate if employee and project exists

        EmployeeEntry emp = Employees.getEmployee(employee);
        ProjectAssigmentEntry assigment = ProjectAssigments.getAssigment(project, employee);
        if (Objects.nonNull(emp)){
            return  responseBuiler.error("Employee not found");
        }else if(Objects.nonNull(assigment.getLevel())){
            if (level.equals(assigment.getLevel())) {
                return responseBuiler.error("already_assigned level");
            }else {
                return responseBuiler.error("Employee already in level" + assigment.getLevel());
            }
        }
        assigment.setLevel(level);
        return responseBuiler.success();
    }

    @Override
    public Response unsetLevel(String project, String employee) {
        ProjectAssigmentEntry assigment = ProjectAssigments.getAssigment(project, employee);
        if (Objects.nonNull(assigment)){
            assigment.setLevel(null);
        }
        return responseBuiler.success();
    }
}
