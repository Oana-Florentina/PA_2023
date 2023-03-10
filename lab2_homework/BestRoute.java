import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents the best route Problem.
 */
public class BestRoute {
    /**
     * The list of all locations that have been created.
     */
    private List<Location> locations;
    /**
     * The list of all roads that have been created.
     */
    private List<Road> roads;
    /**
     * Creates a new BestRoute object with an empty list of locations and roads.
     */
    public BestRoute() {
        locations = new ArrayList<Location>();
        roads = new ArrayList<Road>();
    }
    /**
     * Adds the given location to the list of all locations if it is not already there.
     *
     * @param location the location to add to the list of all locations
     */
    public boolean addLocation(Location location) {
        if (locations.contains(location)) {
            return false; // location already exists
        }
        locations.add(location);
        return true;
    }
    /**
     * Adds the given road to the list of all roads if it is not already there.
     *
     * @param road the road to add to the list of all roads
     */
    public boolean addRoad(Road road) {
        if (roads.contains(road)) {
            return false; // road already exists
        }
        roads.add(road);
        return true;
    }

    // other methods
}