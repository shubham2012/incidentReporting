package Dao;

import Domain.IncidentEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shubham Gupta on 24/08/19.
 */
public class Incidents {

    private static int counter = 0;
    private static List<IncidentEntry> incidents = new ArrayList<>();

    public static IncidentEntry addIncident(IncidentEntry incidentEntry){
        incidentEntry.setId(++counter);
        incidents.add(incidentEntry);
        return incidentEntry;
    }

    public static List<IncidentEntry> getAllIncidents(){
        return incidents;
    }

}
