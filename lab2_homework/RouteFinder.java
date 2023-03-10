import java.util.ArrayList;
import java.util.List;

/**
 * checks if there is a route between a location adn a destination
 */
public class RouteFinder {
    private List<Road> roads;

    public RouteFinder(List<Road> roads, Location start, Location dest) {
        this.roads = roads;
        RouteFound(start, dest);
    }

    /**
     * Returns true if it is possible to go from the starting location to the destination location using the given roads,
     * false otherwise.
     *
     * @param start the starting location
     * @param dest  the destination location
     * @return true if it is possible to go from the starting location to the destination location using the given roads,
     * false otherwise
     */
    public boolean isRoutePossible(Location start, Location dest) {
        // Create a list to keep track of visited locations
        List<Location> visited = new ArrayList<>();

        // Add the starting location to the list of visited locations
        visited.add(start);

        // Use a recursive helper function to check if a route exists from the starting location to the destination location

        return isRoutePossibleHelper(start, dest, visited);

    }

    /**
     * A recursive helper function to check if a route exists from the current location to the destination location.
     *
     * @param current the current location
     * @param dest    the destination location
     * @param visited a list of visited locations
     * @return true if a route exists from the current location to the destination location, false otherwise
     */
    private boolean isRoutePossibleHelper(Location current, Location dest, List<Location> visited) {
        // Base case: if the current location is the same as the destination location, return true

        if (current.equals(dest)) {
            return true;
        }

        // Check each road that starts at the current location
        for (Road road : current.getRoads(roads)) {
            // Check if the road leads to a location that hasn't been visited yet
            if (!visited.contains(road.getEndLocation())) {
                // Add the destination of the road to the list of visited locations
                visited.add(road.getEndLocation());

                // Recursively check if a route exists from the destination of the road to the destination location
                if (isRoutePossibleHelper(road.getEndLocation(), dest, visited)) {

                    return true;
                }

                // Remove the destination of the road from the list of visited locations (backtrack)
                visited.remove(road.getEndLocation());
            }
        }

        // If none of the roads from the current location lead to the destination location, return false
        return false;
    }

    public void RouteFound(Location start, Location dest) {
        if (isRoutePossible(start, dest) || isRoutePossible(dest, start)) {
            System.out.println("We found a route from " + start.getName() + " to " + dest.getName() + "!");
        } else {
            System.out.println("There is no route from " + start.getName() + " to " + dest.getName() + " :(");
        }
    }
}
