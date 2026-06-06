package parkinglot.service;

import java.util.List;
import java.util.Map;

import parkinglot.models.ParkingFloor;
import parkinglot.models.ParkingTicket;
import parkinglot.strategy.feestrategy.FeeStrategy;
import parkinglot.strategy.parkingstrategy.ParkingStrategy;

public class ParkingLotSystem {
    private final ParkingStrategy parkingStrategy;
    private final List<ParkingFloor> floors;
    private final FeeStrategy feeStrategy;
    private final Map<String, ParkingTicket> activeTickets;
    private static volatile ParkingLotSystem instance;

    ParkingLotSystem(ParkingStrategy parkingStrategy, List<ParkingFloor> floors, FeeStrategy feeStrategy, Map<String, ParkingTicket> activeTickets) {
        this.parkingStrategy = parkingStrategy;
        this.floors = floors;
        this.feeStrategy = feeStrategy;
        this.activeTickets = activeTickets;
    }

    public static synchronized ParkingLotSystem getInstance(
            ParkingStrategy parkingStrategy,
            List<ParkingFloor> floors,
            FeeStrategy feeStrategy,
            Map<String, ParkingTicket> activeTickets
    ) {

        if(instance == null) {
            instance = new ParkingLotSystem(
                parkingStrategy,
                floors,
                feeStrategy,
                activeTickets
            );
        }

        return instance;
    }

    public ParkingStrategy getParkingStrategy() {
        return parkingStrategy;
    }

    public List<ParkingFloor> getParkingFloor() {
        return floors;
    }

    public FeeStrategy getFeeStrategy() {
        return feeStrategy;
    }

    public Map<String, ParkingTicket> getActiveTickets() {
        return activeTickets;
    }

    public void addFloor(ParkingFloor parkingFloor) {
        floors.add(parkingFloor);
    }
}
