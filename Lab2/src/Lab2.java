public class Lab2 {
    public static void main(String[] args) {
        Lab2 lab2 = new Lab2();
        lab2.compulsory();
    }

    void compulsory(){
        // Create some location objects
        Location loc1 = new Location("Suceava", LocationType.city, 47.647001, 26.2522599);
        Location loc2 = new Location("Iasi", LocationType.city, 47.1615416, 27.5837224);
        Location loc3 = new Location("Paris", LocationType.city, 48.8534951, -87.6298);

        // Print the location objects
        System.out.println(loc1);
        System.out.println(loc2);
        System.out.println(loc3);

        // Create some road objects
        Road road1 = new Road(loc1, loc2, RoadType.highways, 2789.3, 65);
        Road road2 = new Road(loc2, loc3, RoadType.express, 2048.5, 55);

        // Print the road objects
        System.out.println(road1);
        System.out.println(road2);
    }
}