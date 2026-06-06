package parkinglot.strategy.parkingstrategy;

import java.util.List;
import java.util.Optional;

import parkinglot.models.ParkingSpot;
import parkinglot.models.Vehicle;

public class BestFitStrategy implements ParkingStrategy {
    
    @Override
    public Optional<ParkingSpot> finalSpot(List<ParkingSpot> parkingSpot, Vehicle vechile) {
        return null; // implement this properly
    }    
}
