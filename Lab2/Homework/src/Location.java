import java.util.ArrayList;
import java.util.List;

public  abstract class Location {
    private
    String name;

    private double x, y;
    private static List<Location> locations = new ArrayList<>();
    public Location(String name, double x, double y) {
        this.name = name;
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


    public abstract String getType();
   @Override
    public String toString() {
        return "{" +
                " " + name +
                ", " +"tip" +
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
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Location)) {
            return false;
        }
        Location other = (Location) obj;
        return name.equals(other.name) && x == other.x && y == other.y;
    }
    public static boolean locationExists(Location loc) {
        for (Location l : locations) {
            if (l.equals(loc)) {
                return true;
            }
        }
        return false;
    }

}
