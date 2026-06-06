package parkinglot.strategy.feestrategy;

import java.util.Map;

import parkinglot.enums.VehicleSize;
import parkinglot.models.ParkingTicket;

public class VehicleBasedFeeStrategy implements FeeStrategy {
    private final Map<VehicleSize, Double> ratePerVehicle;

    VehicleBasedFeeStrategy(Map<VehicleSize, Double> ratePerVehicle) {
        this.ratePerVehicle = ratePerVehicle;
    }

    @Override 
    public Double calculateFee(ParkingTicket parkingTicket) {

        long diffMilliSec = parkingTicket.getExitTimeStamp().getTimestamp().getTime() - parkingTicket.getEnteryTimeStamp().getTimestamp().getTime();
        long totalHours = (diffMilliSec / 1000 * 60 * 60);        

        return totalHours * ratePerVehicle.get(parkingTicket.getVehicle().getVechileSize());
    }
}
