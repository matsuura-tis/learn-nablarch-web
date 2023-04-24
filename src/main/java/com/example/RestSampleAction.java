package com.example;

import nablarch.fw.ExecutionContext;
import nablarch.fw.web.HttpRequest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.Serializable;

@Path("/sample")
public class RestSampleAction {
    @GET()
    @Produces(MediaType.APPLICATION_JSON)
    public Object index(HttpRequest req, ExecutionContext ctx) {
        var res = new Res();
        res.setMessage("hello");
        return res;
    }
}

class Res implements Serializable {
    private static final long serialVersionUID = 1L;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
