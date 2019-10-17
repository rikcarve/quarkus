package ch.carve.quarkus;

//@JsonFormat(shape = Shape.OBJECT)
public enum CountryCode {
    CH("CH", "CHE", 756);

    String alpha2;
    String alpha3;
    int numeric3;

    private CountryCode(String alpha2, String alpha3, int numeric3) {
        this.alpha2 = alpha2;
        this.alpha3 = alpha3;
        this.numeric3 = numeric3;
    }

    public String getAlpha2() {
        return alpha2;
    }

    public String getAlpha3() {
        return alpha3;
    }

    public int getNumeric3() {
        return numeric3;
    }

}
