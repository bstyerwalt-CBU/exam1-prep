import java.util.Objects;

public class Circle implements Cloneable{
    private Point center;
    private int radius;

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return radius == circle.radius &&
                Objects.equals(center, circle.center);
    }

    @Override
    public String toString() {
        return "center: " + center.toString() + ", radius: " + radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, radius);
    }

    @Override
    public Circle clone() {
        try {
            Circle copy = (Circle) super.clone();
            //copy.center = this.center.clone(); //deep copy!
            return copy;
        }catch(CloneNotSupportedException e){
            return null; //never executed
        }
    }
}
