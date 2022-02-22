
public class Point implements Cloneable {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void translate(int dX, int dY) {
        x += dX;
        y += dY;
    }


    // Override toString
    @Override
    public String toString() {
        return "X = " + x + ", Y = " + y;
    }


    // Override Equals
    @Override
    public boolean equals(Object obj) {
        if (obj != null && getClass() == obj.getClass()) {
            Point p = (Point) obj;

            return  (this.x == p.x && this.y == p.y);
        }

        return false;
    }


    // Override hashCode
    @Override
    public int hashCode() {
        return (61 * x) + (227 * y);
    }


    // Override clone
    @Override
    protected Object clone() throws CloneNotSupportedException {
        try {
            Point copy = (Point) super.clone();
            return copy;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
