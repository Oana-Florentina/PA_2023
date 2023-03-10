import java.util.ArrayList;
import java.util.List;

public class Lab2 {
    public static void main(String[] args) {
        Lab2 lab2 = new Lab2();
        lab2.homework();
    }

    void homework() {
        // Create location objects
        List<Location> allLocations = new ArrayList<Location>();
        Location loc1 = new AirportLocation("Suceava-Airport", 47.647001, 26.2522599, 6);
        Location loc2 = new CityLocation("Bucharest", 44.4268, 26.1025, 1000000);
        Location loc3 = new CityLocation("Cluj-Napoca", 46.7712101, 23.6236359, 324576);
        Location loc4 = new GasStation("OMV", 47.647001, 26.2522599, 11);
        Location loc5 = new CityLocation("Bucharest", 44.4268, 26.1025, 1000000);//should not be added twice!
        Location loc6 = new CityLocation("Suceava", 44.4268, 26.1025, 1000000);
        BestRoute problem = new BestRoute();

        if (problem.addLocation(loc2))
            allLocations.add(loc2);
        if (problem.addLocation(loc1))
            allLocations.add(loc1);
        if (problem.addLocation(loc3))
            allLocations.add(loc3);
        if (problem.addLocation(loc4))
            allLocations.add(loc4);
        if (problem.addLocation(loc5))
            allLocations.add(loc5);
        if (problem.addLocation(loc6))
            allLocations.add(loc6);
        // Print the location objects
        for (Location location : allLocations) {
            System.out.println(location);
        }

        // Create road objects
        List<Road> allRoads = new ArrayList<Road>();
        Road road1 = new Road(loc3, loc1, RoadType.highways, 100, 65);
        Road road2 = new Road(loc2, loc1, RoadType.express, 2048.5, 55);
        Road road3 = new Road(loc2, loc3, RoadType.express, 2048.5, 55);

        if (problem.addRoad(road1))
            allRoads.add(road1);
        if (problem.addRoad(road2))
            allRoads.add(road2);
        if (problem.addRoad(road3))
            allRoads.add(road3);
        // Print the road objects
        for (Road road : allRoads) {
            System.out.println(road);
        }
        RouteFinder routeFinder = new RouteFinder(allRoads, loc1, loc3);

        RouteFinder routeFinder2 = new RouteFinder(allRoads, loc2, loc6);
    }
}