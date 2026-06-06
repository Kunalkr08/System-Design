package parkinglot.strategy.feestrategy;

import parkinglot.models.ParkingTicket;

public interface FeeStrategy {
    Double calculateFee(ParkingTicket parkingTicket);
} 
