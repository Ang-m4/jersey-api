package javeriana.ms.rest.serializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import javeriana.ms.rest.model.Trip;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public class TripSerializer {

    private static File file = new File("src/resources/trips.json");
    private static ObjectMapper mapper  = new ObjectMapper();

    private static List<Trip> trips;

    public static List<Trip> getTrips() {
        mapper.registerModule(new JavaTimeModule());
        try {
            trips = mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(List.class, Trip.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return trips;
    }

    public static int saveTrip(Trip trip){
        mapper.registerModule(new JavaTimeModule());
        try {
            trips = getTrips();
            trips.add(trip);
            mapper.writeValue(file,trips);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return trip.getId();
    }

    public static boolean deleteTrip(int id){
        boolean deleted = false;
        mapper.registerModule(new JavaTimeModule());
        try {
            trips = getTrips();
            deleted = trips.removeIf(trip -> (trip.getId() == id));
            mapper.writeValue(file,trips);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return deleted;
    }

    public static Trip findTripById(int id){
        trips = getTrips();
        Optional<Trip> trip = trips.stream().filter(t -> t.getId() == id).findFirst();
        if (trip.isPresent()){
            return trip.get();
        }
        return null;
    }
    public static Trip updateTrip(int id, String source, String target){
        mapper.registerModule(new JavaTimeModule());
        try {
            trips = getTrips();
            trips.stream()
                    .filter(trip -> trip.getId() == id)
                    .findFirst()
                    .ifPresent(trip -> {trip.setDestination(target); trip.setSource(source);});
            mapper.writeValue(file,trips);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return findTripById(id);
    }
}
