public final class ImmutableFraction implements Cloneable, Comparable<ImmutableFraction> {
    private final int numerator, denominator;

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

    public ImmutableFraction add(ImmutableFraction other) {
        int n = numerator * other.denominator + other.numerator * denominator;
        int d = denominator * other.denominator;

        return new ImmutableFraction(n, d);
    }

    public ImmutableFraction subtract(ImmutableFraction other) {
        int n = numerator * other.denominator - other.numerator * denominator;
        int d = denominator * other.denominator;

        return new ImmutableFraction(n,d);
    }

    public ImmutableFraction multiply(ImmutableFraction other) {
        int n = numerator * other.numerator;
        int d = denominator * other.denominator;

        return new ImmutableFraction(n,d);
    }


    public ImmutableFraction divide(ImmutableFraction other) {
        int n = numerator * other.denominator;
        int d = denominator * other.numerator;

        return new ImmutableFraction(n,d);
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        } else {
            return gcd(b, a % b);
        }
    }
}