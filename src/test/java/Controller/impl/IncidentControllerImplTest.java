package Controller.impl;

import Domain.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Shubham Gupta on 24/08/19.
 */
class IncidentControllerImplTest {

    private IncidentControllerImpl controller = new IncidentControllerImpl();


    @Test
    void createIncident() {
        Response incident = controller.createIncident("Inci1", "proj0");
        System.out.println(incident);
    }

    @Test
    void notifyIncident() {
    }

    @Test
    void escalateIncident() {
    }

    @Test
    void ackIncident() {
    }
}