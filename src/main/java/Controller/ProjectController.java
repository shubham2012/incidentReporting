package Controller;

import Domain.Response;

/**
 * Created by Shubham Gupta on 24/08/19.
 */
public interface ProjectController {

    Response addProject(String name);

    Response assignProject(String project, String employee);

    Response setLevel(String project, String employee, Integer level);

    Response unsetLevel(String project, String employee);
}
