

import java.util.ArrayList;
import java.util.List;
/**

 A class representing a route-finding problem.
 */
public class RouteProblem {
    private List<Location> locations = new ArrayList();
    private List<Road> roads = new ArrayList();

    /**

     Adds a location to the list of locations in this RouteProblem.
     @param location the location to add
     */
    public void addLocation(Location location) {
        this.locations.add(location);
    }
    /**

     Adds a road to the list of roads in this RouteProblem.
     @param road the road to add
     */
    public void addRoad(Road road) {
        this.roads.add(road);
    }
    /**

     Gets the list of locations in this RouteProblem.
     @return the list of locations
     */
    public List<Location> getLocations() {
        return this.locations;
    }
    /**

     Gets the list of roads in this RouteProblem.
     @return the list of roads
     */
    public List<Road> getRoads() {
        return this.roads;
    }
    /**

     Finds the best route between two locations in this RouteProblem.
     @param startLocation the starting location of the route
     @param endLocation the ending location of the route
     @return the list of roads representing the best route, or null if no route exists
     */
    public List<Road> findBestRoute(Location startLocation, Location endLocation) {
        return null;
    }
}
