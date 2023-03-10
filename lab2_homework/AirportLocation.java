
/**

 A class representing an airport location.

 <p>An airport location is a specific type of {@link Location} that also
 contains information about the number of terminals.</p>
 */
public class AirportLocation extends Location {
    private int terminals;
    /**

     Constructs a new AirportLocation object.
     @param name the name of the airport
     @param latitude the latitude of the airport's location
     @param longitude the longitude of the airport's location
     @param nrTerminals the number of terminals at the airport
     */
    public AirportLocation(String name, double latitude, double longitude, int nrTerminals) {
        super(name, latitude, longitude);
        this.terminals = nrTerminals;
    }
    /**

     Returns the number of terminals at this airport location.
     @return the number of terminals
     */
    public int getTerminals() {
        return this.terminals;
    }
    /**

     Returns the type of location, which is always "Airport" for AirportLocation objects.
     @return the type of location
     */
    public String getType() {
        return "Airport";
    }
}
