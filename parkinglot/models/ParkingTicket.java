package parkinglot.models;

import java.security.Timestamp;

public class ParkingTicket {
    private final String ticketId;
    private final ParkingSpot spot;
    private final ParkingFloor parkingFloor;
    private final Timestamp  enteryTimeStamp;
    private final Timestamp exitTimeStamp;
    private final Vehicle vehicle;

    ParkingTicket(String ticketId, ParkingSpot spot, ParkingFloor parkingFloor, Timestamp enteryTimestamp, Timestamp exitTimestamp, Vehicle vehicle) {
        this.ticketId = ticketId;
        this.spot = spot;
        this.parkingFloor = parkingFloor;
        this.enteryTimeStamp = enteryTimestamp;
        this.exitTimeStamp = exitTimestamp;
        this.vehicle = vehicle;
    }
    
    public String getTicketId() {
        return ticketId;
    }

    public ParkingSpot getParkingSpot() {
        return spot;
    }

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public Timestamp getEnteryTimeStamp() {
        return enteryTimeStamp;
    }

    public Timestamp getExitTimeStamp() {
        return exitTimeStamp;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
