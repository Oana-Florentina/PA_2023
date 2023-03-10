/**
 * Represents an airport location with a name, latitude, longitude, and number of terminals.
 * Extends the Location class.
 */
public class AirportLocation extends Location {
    /**
     * The number of terminals at the airport.
     */
    private int terminals;
    /**
     * Constructs an AirportLocation object with the specified name, latitude, longitude, and number of terminals.
     *
     * @param name the name of the airport
     * @param latitude the latitude of the airport's location
     * @param longitude the longitude of the airport's location
     * @param nrTerminals the number of terminals at the airport
     */
    public AirportLocation(String name, double latitude, double longitude, int nrTerminals) {
        super(name, latitude, longitude);
        this.terminals = nrTerminals;
    }
    /**
     * Returns the number of terminals at the airport.
     *
     * @return the number of terminals at the airport
     */
    public int getTerminls(){
        return this.terminals;
    }
    /**
     * Overrides the getType() method in the Location class to return "Airport".
     *
     * @return the string "Airport"
     */
    @Override
    public String getType() {
        return "Airport";
    }
}
