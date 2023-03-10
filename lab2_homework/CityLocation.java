
public class CityLocation extends Location {
    private int population;

    public CityLocation(String name, double latitude, double longitude, int population) {
        super(name, latitude, longitude);
        this.population = population;
    }

    public int getPopulation() {
        return population;
    }

    @Override
    public String getType() {
        return "City";
    }
}
