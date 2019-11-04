package Controller;

import Domain.Response;

/**
 * Created by Shubham Gupta on 24/08/19.
 */
public interface IncidentController {

    Response createIncident(String name, String incident);

    Response notifyIncident(String projectName, Integer incidentId);

    Response escalateIncident(String projectName, Integer incidentId);

    Response ackIncident(String projectName, Integer incidentId, Integer level);

}
