package fr.inra.orleans;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.jetty.http.HttpStatus;

import com.codahale.metrics.annotation.Timed;

@Path("/")
public class Resource {
	
	@GET
	@Timed
	@Path("ping")
	@Produces(MediaType.APPLICATION_JSON)
	public Response ping() throws Exception {	
		
	    return Response.status(HttpStatus.OK_200)
                           .entity(Service.getInstance().ping(0))
                           .build() ;
	}
	
	
	@GET
	@Timed
	@Path("sleep/{duration}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response sleep(@PathParam("duration") int duration ) throws Exception {
            
            return Response.status(HttpStatus.OK_200)
                           .entity(Service.getInstance().ping( duration ))
                           .build() ;
	
                
	}
	

}
