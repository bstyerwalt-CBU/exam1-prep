public class MutableFraction implements Cloneable, Comparable<MutableFraction> {
    private int numerator, denominator;

    public MutableFraction(int n) {
        this.numerator = n;
        this.denominator = 1;
    }

    public MutableFraction(int n, int d) {
        int g = gcd(n, d);
        n /= g;
        d /= g;
        if (d < 0) {
            n = -n;
            d = -d;
        }

        this.numerator = n;
        this.denominator = d;

    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public void setNumerator(int n) {
        this.numerator = n;
    }

    public void setDenominator(int d) {
        this.denominator = d;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && getClass() == obj.getClass()) {
            MutableFraction other = (MutableFraction) obj;
            return numerator == other.numerator && denominator == other.denominator;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        if (denominator == 1) {
            return String.valueOf(numerator);
        } else {
            return numerator + "/" + denominator;
        }
    }

    @Override
    public int compareTo(MutableFraction o) {
        int myCommon = numerator * o.denominator;
        int otherCommon = o.numerator * denominator;
        return myCommon - otherCommon;

    }

    public void add(MutableFraction other) {
        numerator = numerator * other.denominator + other.numerator * denominator;
        denominator = denominator * other.denominator;
    }

    public void subtract(MutableFraction other) {
        numerator = numerator * other.denominator - other.numerator * denominator;
        denominator = denominator * other.denominator;

    }

    public void multiply(MutableFraction other) {
        numerator = numerator * other.numerator;
        denominator = denominator * other.denominator;

    }

    public void divide(MutableFraction other) {
        numerator = numerator * other.denominator;
        denominator = denominator * other.numerator;

    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        } else {
            return gcd(b, a % b);
        }
    }
}