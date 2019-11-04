package Dao;

import Domain.EmployeeEntry;
import Domain.IncidentAssigmentEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shubham Gupta on 24/08/19.
 */
public class IncidentAssigment {

    private static List<IncidentAssigmentEntry> assignmentEntry = new ArrayList<>();

    public static IncidentAssigmentEntry addIncident(EmployeeEntry entry, Integer id){
        IncidentAssigmentEntry incidentAssigmentEntry = new IncidentAssigmentEntry();
        incidentAssigmentEntry.setEmployeeEntry(entry);
        incidentAssigmentEntry.setIncident(id);
        assignmentEntry.add(incidentAssigmentEntry);
        return incidentAssigmentEntry;
    }

    public static List<IncidentAssigmentEntry> getAllIncidents(){
        return assignmentEntry;
    }

    public static IncidentAssigmentEntry getIncident(Integer id){
        return assignmentEntry.stream().filter(x->x.getIncident()==id).findFirst().get();
    }

    public static IncidentAssigmentEntry setAck(Integer id, Integer level){
        IncidentAssigmentEntry incident = assignmentEntry.stream().filter(x -> x.getIncident() == id).findFirst().get();
        incident.setAck(true);
        incident.setLevel(level);
        return incident;
    }

}
