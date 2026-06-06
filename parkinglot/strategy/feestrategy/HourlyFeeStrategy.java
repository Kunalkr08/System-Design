package parkinglot.strategy.feestrategy;

import parkinglot.models.ParkingTicket;

public class HourlyFeeStrategy implements FeeStrategy {

    private final Double ratePerHour;

    HourlyFeeStrategy(Double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    @Override
    public Double calculateFee(ParkingTicket parkingTicket) {
        long diffMilliSec = parkingTicket.getExitTimeStamp().getTimestamp().getTime() - parkingTicket.getEnteryTimeStamp().getTimestamp().getTime();

        long totalHours = (diffMilliSec / 1000 * 60 * 60);

        return totalHours * ratePerHour;
    }
}
