public enum Month {
    JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER;


    // Implement fromInt method
    public Month fromInt(int n) {
            return values()[n];
    }

    // Implement add method
    public Month add(int n) {
            int newMonth = this.ordinal() + n;
            return values()[newMonth];
    }

}