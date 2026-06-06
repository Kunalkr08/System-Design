package parkinglot.strategy.parkingstrategy;

import java.util.List;
import java.util.Optional;

import parkinglot.models.ParkingSpot;
import parkinglot.models.Vehicle;

public interface ParkingStrategy {
    Optional<ParkingSpot> finalSpot(List<ParkingSpot> parkingSpot, Vehicle vechile);
}
