package parkinglot.models;

import java.util.Map;
import java.util.Optional;

public class ParkingFloor {
    private final String floorId;
    private final int floorNumber;
    private final Map<String, ParkingSpot> spots;

    ParkingFloor(String floorId, int floorNumber, Map<String, ParkingSpot> spots) {
        this.floorId = floorId;
        this.floorNumber = floorNumber;
        this.spots = spots;
    }

    public String getFloorId() {
        return floorId;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public Map<String, ParkingSpot> getSpots() {
        return spots;
    }
    
    public void addFloor(ParkingSpot parkingSpot) {
        // implement this
    }

    public Optional<ParkingSpot> findAvailableSpaces(Vehicle vechile) {
        return null;
        // implement this 
    }

    public void displayAvailability() {
        // implement this
    }
}
