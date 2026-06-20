package main.java.com.exercises.list_3.ex_2;


public enum Gear {

    NEUTRAL((short) 0, (short) 0, (short) 0),
    FIRST((short) 1, (short) 0, (short) 24),
    SECOND((short) 2, (short) 25, (short) 48),
    THIRD((short) 3, (short) 49, (short) 72),
    FOURTH((short) 4, (short) 73, (short) 96),
    FIFTH((short) 5, (short) 97, (short) 120),
    REVERSE((short) 6, (short) 0, (short) 24);

    private final short value;
    private final short minSpeed;
    private final short maxSpeed;

    Gear(short value, short minSpeed, short maxSpeed) {
        this.value = value;
        this.minSpeed = minSpeed;
        this.maxSpeed = maxSpeed;
    }

    public short getValue() {
        return value;
    }

    public boolean isValidSpeed(short speed) {
        return speed >= minSpeed && speed <= maxSpeed;
    }

    public static Gear fromValue(short value) {
        for (Gear gear : values()) {
            if (gear.value == value) {
                return gear;
            }
        }

        throw new IllegalArgumentException(
            "Invalid gear value: " + value
        );
    }

    public boolean canShiftTo(Gear target) {

        return switch (this) {

            case NEUTRAL ->
                    target == FIRST ||
                    target == REVERSE;

            case FIRST ->
                    target == NEUTRAL ||
                    target == SECOND;

            case SECOND ->
                    target == FIRST ||
                    target == THIRD;

            case THIRD ->
                    target == SECOND ||
                    target == FOURTH;

            case FOURTH ->
                    target == THIRD ||
                    target == FIFTH;

            case FIFTH ->
                    target == FOURTH;

            case REVERSE ->
                    target == NEUTRAL;

            default -> false;
        };
    }
}
