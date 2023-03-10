import java.util.ArrayList;
import java.util.List;
/**
 * Represents a location of a specific type with a name and coordinates.
 */
public  abstract class Location {
    /**
     * The name of the location.
     */
    private
    String name;
    /**
     * The X, Y coordinates of the location.
     */
    private double x, y;
    /**
     * The list of all locations that have been created.
     */
    private static List<Location> locations = new ArrayList<>();
    /**
     * Creates a new Location with the given name and coordinates.
     *
     * @param name the name of the location
     * @param x the X coordinate of the location
     * @param y the Y coordinate of the location
     */
    public Location(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    /**
     * Sets the name of the location.
     *
     * @param name1 the new name of the location
     */
    public void setName(String name1) {
        name = name1;
    }
    /**
     * Sets the X coordinate of the location.
     *
     * @param x1 the new X coordinate of the location
     */
    public void setX(double x1) {
        x = x1;
    }
    /**
     * Sets the Y coordinate of the location.
     *
     * @param y1 the new Y coordinate of the location
     */
    public void setY(double y1) {
        y = y1;
    }
    /**
     * Returns the type of the location.
     *
     * @return the type of the location
     */
    public abstract String getType();

    /**
     * Returns a string representation of the location in the format:
     * {name, type, x, y}.
     *
     * @return a string representation of the location
     */
    @Override
    public String toString() {
        return "{" +
                " " + name +
                ", " + getType() +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
    /**
     * Returns the name of the location.
     *
     * @return the name of the location
     */
    public String getName() {

        return name;
    }
    /**
     * Returns the X coordinate of the location.
     *
     * @return the X coordinate of the location
     */
    public double getX() {
        return x;
    }
    /**
     * Returns the Y coordinate of the location.
     *
     * @return the Y coordinate of the location
     */
    public double getY() {
        return y;
    }
    /**
     * Returns true if the given object is equal to this location.
     *
     * @param obj the object to compare to this location
     * @return true if the given object is equal to this location
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Location)) {
            return false;
        }
        Location other = (Location) obj;
        return name.equals(other.name) && x == other.x && y == other.y;
    }

    /**

     Returns a list of roads that start at this location from the given list of roads.
     @param roads a list of Road objects
     @return a list of Road objects that start at this location
     */
    public List<Road> getRoads(List<Road> roads) {
        List<Road> startingRoads = new ArrayList<Road>();
        for (Road road : roads) {
            if (road.getStartLocation().equals(this)) {
                startingRoads.add(road);
            }
        }
        return startingRoads;
    }
}
