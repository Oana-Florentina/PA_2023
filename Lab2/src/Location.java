public class Location {
    private
    String name;
    private LocationType type;
    private double x, y;
    public Location(String name, LocationType type, double x, double y) {
        this.name = name;
        this.type = type;
        this.x = x;
        this.y = y;
    }
    public void setName(String name1) {
        name = name1;
    }

    public void setX(double x1) {
        x = x1;
    }

    public void setY(double y1) {
        y = y1;
    }

    public void setType(LocationType type) {
        this.type = type;
    }

    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
    public String getName() {

        return name;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
