/**
 * Represents a gas station location with a name, latitude, longitude, and gas price.
 * Extends the Location class.
 */
public class GasStation extends Location {
    /**
     * The price of gas at the station.
     */
    private int gasPrice;
    /**
     * Constructs a GasStation object with the specified name, latitude, longitude, and gas price.
     *
     * @param name the name of the gas station
     * @param latitude the latitude of the gas station's location
     * @param longitude the longitude of the gas station's location
     * @param gasPrice the price of gas at the station
     */
    public GasStation(String name, double latitude, double longitude, int gasPrice) {
        super(name, latitude, longitude);
        this.gasPrice = gasPrice;
    }
    /**
     * Returns the price of gas at the station.
     *
     * @return the price of gas at the station
     */
    public int getGasPrice() {
        return gasPrice;
    }
    /**
     * Overrides the getType() method in the Location class to return "Gas Station".
     *
     * @return the string "Gas Station"
     */
    @Override
    public String getType() {
        return "Gas Station";
    }
}
