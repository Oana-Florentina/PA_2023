import java.util.Objects;

import static java.lang.Math.pow;

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
        if(length*length >=  ( (pow(startLocation.getX()- endLocation.getX(),2))+(pow(startLocation.getY()- endLocation.getY(),2)))){
            this.length = length;
        }
        else throw new IllegalArgumentException("The distance is smaller than the euclidian distance;");
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
    @Override
    public String toString() {
        return "Road " +
                "from " + startLocation +
                ", to " + endLocation +
                "( type=" + type +
                ", length=" + length +
                ", speedLimit=" + speedLimit +
                " )";
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
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Road other = (Road) obj;
        if (!Objects.equals(this.startLocation, other.startLocation)) {
            return false;
        }
        if (!Objects.equals(this.endLocation, other.endLocation)) {
            return false;
        }
        return true;
    }
}
