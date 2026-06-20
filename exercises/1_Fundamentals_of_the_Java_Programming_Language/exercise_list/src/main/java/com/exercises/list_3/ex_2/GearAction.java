package main.java.com.exercises.list_3.ex_2;

public enum GearAction {

    SHIFT_UP(0),
    SHIFT_DOWN(1),
    MAINTAIN(2);

    private final short ActionValue;

    GearAction(short ActionValue) {
        this.ActionValue = ActionValue;
    }

    public static GearAction fromValue(short ActionValue) {

        for (GearAction action : values()) {
            if (action.ActionValue == ActionValue) {
                return action;
            }
        }

        throw new IllegalArgumentException(
            "Invalid action: " + ActionValue
        );
    }
}
