package Utils;

import Domain.Response;
import Domain.Status;

/**
 * Created by Shubham Gupta on 24/08/19.
 */
public class BuildResponse {

    public Response success(){
        Response response = new Response();
        response.setStatus(Status.SUCCESS);
        return response;
    }

    public Response error(String message){
        Response response = new Response();
        response.setStatus(Status.ERROR);
        response.setMessage(message);
        return response;
    }
}
