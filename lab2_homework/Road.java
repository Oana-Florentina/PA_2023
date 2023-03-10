import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.Math.pow;
/**
 * Represents a road of a specific type between two locations.
 */
public class Road {
    /**
     * The start location of the road.
     */
    private Location startLocation;
    /**
     * The end location of the road.
     */
    private Location endLocation;
    /**
     * The type of the road.
     */
    private RoadType type;
    /**
     * The length of the road.
     */
    private double length;
    /**
     * The speed limit of the road.
     */
    private double speedLimit;
    /**
     * Creates a new road from a start location to a destination.
     *
     * @param startLocation the name of the start location
     * @param endLocation the name of the end location
     * @param type the type of the road
     * @param length the length of the road
     * @param speedLimit the speed limit of the road
     */
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
    /**
     * Sets the name of the start location.
     *
     * @param startLocation the new name of the start location
     */
    public void setStartLocation(Location startLocation) {
        this.startLocation = startLocation;
    }
    /**
     * Sets the name of the destination.
     *
     * @param endLocation  the new name of the destination
     */
    public void setEndLocation(Location endLocation) {
        this.endLocation = endLocation;
    }
    /**
     * Sets the type of the road.
     *
     * @param type the new type of the road
     */

    public void setType(RoadType type) {
        this.type = type;
    }
    /**
     * Sets the length of the road.
     *
     * @param length the new length of the road
     */
    public void setLength(double length) {
        this.length = length;
    }
    /**
     * Sets the speed limit of the road.
     *
     * @param speedLimit the new speed limit of the road
     */
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
