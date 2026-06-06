package parkinglot.models;

import parkinglot.enums.VehicleSize;

public class ParkingSpot {
    private final VehicleSize spotSize;
    private final String spotId;
    private final boolean isOccupied;
    private final Vehicle vechile;

    ParkingSpot(VehicleSize spotSize, String spotId, boolean isOccupied, Vehicle vechile) {
        this.spotSize = spotSize;
        this.spotId = spotId;
        this.isOccupied = isOccupied;
        this.vechile = vechile;
    }

    public VehicleSize getSpotSize() {
        return spotSize;
    }

    public String getSpotId() {
        return spotId;
    }

    public boolean getIsOccupied() {
        return isOccupied;
    }

    public Vehicle getVechile() {
        return vechile;
    }
}

// Vechile, FeeStrategy, Floor, VechileSize, ParkingTicket, ParkingSpot,  ParkingStrategy, VechileType, ParkingLotSystem