import java.util.ArrayList;
import java.util.List;


public class BestRoute {
    private List<Location> locations;
    private List<Road> roads;

    public BestRoute() {
        locations = new ArrayList<Location>();
        roads = new ArrayList<Road>();
    }

    public boolean addLocation(Location location) {
        if (locations.contains(location)) {
            return false; // location already exists
        }
        locations.add(location);
        return true;
    }

    public boolean addRoad(Road road) {
        if (roads.contains(road)) {
            return false; // road already exists
        }
        roads.add(road);
        return true;
    }

    // other methods
}