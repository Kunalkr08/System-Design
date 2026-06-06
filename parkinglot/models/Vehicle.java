package parkinglot.models;

import parkinglot.enums.VehicleSize;

public class Vehicle {
    private final String id;
    private final VehicleSize vechileSize;
    private final String licenseNumber;

    Vehicle(String id, VehicleSize vechileSize, String licenseNumber) {
        this.id = id;
        this.vechileSize = vechileSize;
        this.licenseNumber = licenseNumber;
    }

    public String getId() {
        return id;
    }

    public VehicleSize getVechileSize() {
        return vechileSize;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }
}

// id, size, license
