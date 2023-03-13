package javeriana.ms.rest.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import javeriana.ms.rest.model.Trip;
import javeriana.ms.rest.serializers.TripSerializer;

import java.time.LocalDate;
import java.util.List;

@Path("trips")
public class TripResource {
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Trip> getXmlTrips() {
        return TripSerializer.getTrips();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Trip> getJsonTrips() {
        return TripSerializer.getTrips();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public int createTrip(Trip trip){
        return  TripSerializer.saveTrip(trip);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public boolean deleteTrip(@PathParam("id") int id){
        return TripSerializer.deleteTrip(id);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Trip updateTrip(@PathParam("id") int id,
                           @QueryParam("source") String source,
                           @QueryParam("target") String target ){
        return TripSerializer.updateTrip(id,source,target);
    }
}
