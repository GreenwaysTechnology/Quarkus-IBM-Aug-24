package com.ibm.fault.bulkhead;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.Bulkhead;
import org.eclipse.microprofile.faulttolerance.Fallback;

@Path("bulkhead")
public class BulkHeadResource {

    @GET
    @Bulkhead(value = 5) //here only 5 concurrent calls allowed
    @Fallback(fallbackMethod = "handleBulkHead")
    public Response dontOverload() {
        System.out.println("Bulk is called");
        return Response.ok("Bulk").build();
    }

    public Response handleBulkHead(){
        System.out.println("Fallback response");
        return Response.ok("sorry system busy").build();
    }
}
