package app.domain.models.enums;


public enum DiscountPercent {
    ZERO(0),
    FIVE(5),
    TEN(10),
    FIFTEEN(15),
    TWENTY(20),
    THIRTY(30),
    FORTY(40),
    FIFTY(50);

    private final int value;

    private DiscountPercent(final int newValue) {
        value = newValue;
    }

    public int getValue() {
        return value;
    }
}
