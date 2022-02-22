public class ImmutableFraction implements Cloneable, Comparable<ImmutableFraction> {
    private int numerator, denominator;

    public ImmutableFraction(int n) {
        this.numerator = n;
        this.denominator = 1;
    }

    public ImmutableFraction(int n, int d) {
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
            ImmutableFraction other = (ImmutableFraction) obj;
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
    public int compareTo(ImmutableFraction o) {
        int myCommon = numerator * o.denominator;
        int otherCommon = o.numerator * denominator;
        return myCommon - otherCommon;

    }

    public void add(ImmutableFraction other) {
        numerator = numerator * other.denominator + other.numerator * denominator;
        denominator = denominator * other.denominator;
    }

    public void subtract(ImmutableFraction other) {
        numerator = numerator * other.denominator - other.numerator * denominator;
        denominator = denominator * other.denominator;

    }

    public void multiply(ImmutableFraction other) {
        numerator = numerator * other.numerator;
        denominator = denominator * other.denominator;

    }

    public void divide(ImmutableFraction other) {
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