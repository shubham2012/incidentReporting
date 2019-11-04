package Controller.impl;

import Controller.IncidentController;
import Dao.Employees;
import Dao.IncidentAssigment;
import Dao.Incidents;
import Dao.ProjectAssigments;
import Domain.EmployeeEntry;
import Domain.IncidentAssigmentEntry;
import Domain.IncidentEntry;
import Domain.ProjectAssigmentEntry;
import Domain.Response;
import Utils.BuildResponse;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Shubham Gupta on 24/08/19.
 */
public class IncidentControllerImpl implements IncidentController {

    private BuildResponse responseBuiler = new BuildResponse();

    @Override
    public Response createIncident(String name, String incident) {
        IncidentEntry incidentEntry = new IncidentEntry(name, incident);
        IncidentEntry response = Incidents.addIncident(incidentEntry);
        Response success = responseBuiler.success();
        success.setId(response.getId());
        return success;
    }

    @Override
    public Response notifyIncident(String projectName, Integer incidentId) {

        //TODO validate incident, Employee and Project exists

        List<ProjectAssigmentEntry> allAssigmentsForProjects = ProjectAssigments.getAllProjectAssigments()
                .stream()
                .filter(x -> x.getProject().equalsIgnoreCase(projectName))
                .collect(Collectors.toList());

        Collections.sort(allAssigmentsForProjects, Comparator.comparing(ProjectAssigmentEntry::getLevel));

        EmployeeEntry employee = Employees.getEmployee(allAssigmentsForProjects.get(0).getEmployee_name());

        IncidentAssigment.addIncident(employee, incidentId);

        Response response = responseBuiler.success();
        response.setEmployeeEntry(employee);
        return response;
    }

    @Override
    public Response escalateIncident(String projectName, Integer incidentId) {

        //TODO validate incident, Employee and Project exists

        IncidentAssigmentEntry incident = IncidentAssigment.getIncident(incidentId);

        //TODO iterate over all available levels and mod that for level rotation
        Integer nextLevel = incident.getLevel()+1;

        List<ProjectAssigmentEntry> allAssigmentsForProjects = ProjectAssigments.getAllProjectAssigments()
                .stream()
                .filter(x -> x.getProject().equalsIgnoreCase(projectName))
                .filter(y->y.getLevel() >= nextLevel)
                .collect(Collectors.toList());

        Collections.sort(allAssigmentsForProjects, Comparator.comparing(ProjectAssigmentEntry::getLevel));

        EmployeeEntry employee = Employees.getEmployee(allAssigmentsForProjects.get(0).getEmployee_name());

        IncidentAssigment.addIncident(employee, incidentId);

        Response response = responseBuiler.success();
        response.setEmployeeEntry(employee);
        return response;
    }

    @Override
    public Response ackIncident(String projectName, Integer incidentId, Integer level) {
        IncidentAssigmentEntry incidentEntry = IncidentAssigment.setAck(incidentId, level);
        return responseBuiler.success();
    }


}
