package com.tw.javajersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class API {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response hello() {
        return Response.status(200).entity("hello world").build();
    }
}
