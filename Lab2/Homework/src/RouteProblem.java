import java.util.ArrayList;
import java.util.List;

public class RouteProblem {
    private List<Location> locations;
    private List<Road> roads;

    public RouteProblem() {
        locations = new ArrayList<>();
        roads = new ArrayList<>();
    }

    public void addLocation(Location location) {
        locations.add(location);
    }

    public void addRoad(Road road) {
        roads.add(road);
    }

    public List<Location> getLocations() {
        return locations;
    }

    public List<Road> getRoads() {
        return roads;
    }

    public List<Road> findBestRoute(Location startLocation, Location endLocation) {
        // TODO
        return null;
    }
}