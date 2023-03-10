/**

 CityLocation is a class that extends the Location class and represents a location in a city with a population.
 */
public class CityLocation extends Location {
    /** The population of the city location. */
    private int population;
    /**

     Constructs a CityLocation object with the given parameters.
     @param name the name of the city location
     @param latitude the latitude of the city location
     @param longitude the longitude of the city location
     @param population the population of the city location
     */
    public CityLocation(String name, double latitude, double longitude, int population) {
        super(name, latitude, longitude);
        this.population = population;
    }
    /**

     Returns the population of the city location.
     @return the population of the city location
     */
    public int getPopulation() {
        return population;
    }
    /**

     Returns the type of the location, which is "City" for CityLocation objects.
     @return the type of the location, which is "City"
     */
    @Override
    public String getType() {
        return "City";
    }
}
