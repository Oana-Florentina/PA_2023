public class Road {
    private Location startLocation;
    private Location endLocation;
    private RoadType type;
    private double length;
    private double speedLimit;

    public Road(Location startLocation, Location endLocation, RoadType type, double length, double speedLimit) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.type = type;
        this.length = length;
        this.speedLimit = speedLimit;
    }
    public void setStartLocation(Location startLocation) {
        this.startLocation = startLocation;
    }

    public void setEndLocation(Location endLocation) {
        this.endLocation = endLocation;
    }

    public void setType(RoadType type) {
        this.type = type;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setSpeedLimit(double speedLimit) {
        this.speedLimit = speedLimit;
    }

    public String toString() {
        return "Road{" +
                "startLocation=" + startLocation +
                ", endLocation=" + endLocation +
                ", type=" + type +
                ", length=" + length +
                ", speedLimit=" + speedLimit +
                '}';
    }
    public double getSpeedLimit() {
        return speedLimit;
    }

    public double getLength() {
        return length;
    }

    public Location getEndLocation() {
        return endLocation;
    }

    public Location getStartLocation() {
        return startLocation;
    }

    public RoadType getType() {
        return type;
    }
}
