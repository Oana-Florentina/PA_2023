//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Objects;
/**

 Represents a road that connects two locations with a certain type, length and speed limit.
 */
public class Road {

    private Location startLocation;
    private Location endLocation;
    private RoadType type;
    private double length;
    private double speedLimit;
    /**

     Creates a new road with the specified start and end locations, type, length and speed limit.
     @param startLocation the location where the road starts
     @param endLocation the location where the road ends
     @param type the type of road (highway, express or country)
     @param length the length of the road in kilometers
     @param speedLimit the speed limit of the road in kilometers per hour
     @throws IllegalArgumentException if the distance between start and end location is smaller than the specified length
     */
    public Road(Location startLocation, Location endLocation, RoadType type, double length, double speedLimit) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.type = type;
        if (length * length >= Math.pow(startLocation.getX() - endLocation.getX(), 2.0) + Math.pow(startLocation.getY() - endLocation.getY(), 2.0)) {
            this.length = length;
            this.speedLimit = speedLimit;
        } else {
            throw new IllegalArgumentException("The distance is smaller than the euclidian distance;");
        }
    }
    /**

     Sets the start location of the road.
     @param startLocation the new start location
     */
    public void setStartLocation(Location startLocation) {
        this.startLocation = startLocation;
    }
    /**

     Sets the end location of the road.
     @param endLocation the new end location
     */
    public void setEndLocation(Location endLocation) {
        this.endLocation = endLocation;
    }
    /**

     Sets the type of the road.
     @param type the new type
     */
    public void setType(RoadType type) {
        this.type = type;
    }
    /**

     Sets the length of the road.
     @param length the new length
     */
    public void setLength(double length) {
        this.length = length;
    }
    /**

     Sets the speed limit of the road.
     @param speedLimit the new speed limit
     */
    public void setSpeedLimit(double speedLimit) {
        this.speedLimit = speedLimit;
    }
    /**

     Returns a string representation of the road.
     @return a string representation of the road
     */
    public String toString() {
        return "Road from " + this.startLocation + ", to " + this.endLocation + "( type=" + this.type + ", length=" + this.length + ", speedLimit=" + this.speedLimit + " )";
    }
    /**

     Returns the speed limit of the road.
     @return the speed limit of the road in kilometers per hour
     */
    public double getSpeedLimit() {
        return this.speedLimit;
    }
    /**

     Returns the length of the road.
     @return the length of the road in kilometers
     */
    public double getLength() {
        return this.length;
    }
    /**

     Returns the end location of the road.
     @return the end location of the road
     */
    public Location getEndLocation() {
        return this.endLocation;
    }
    /**

     Returns the start location of the road.
     @return the start location of the road
     */
    public Location getStartLocation() {
        return this.startLocation;
    }
    /**

     Returns the type of the road.
     @return the type of the road
     */
    public RoadType getType() {
        return this.type;
    }
    /**

     Indicates whether some other object is "equal to" this one.
     @param obj the reference object with which to compare
     @return true if this object is the same as the obj argument; false otherwise
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            Road other = (Road)obj;
            if (!Objects.equals(this.startLocation, other.startLocation)) {
                return false;
            } else {
                return Objects.equals(this.endLocation, other.endLocation);
            }
        }
    }
}
