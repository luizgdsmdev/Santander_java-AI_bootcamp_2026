package main.java.com.exercises.list_3.ex_2;

public class carRules{

    protected boolean startEngineRules(boolean isEngineOn, Gear gear, short speed) {
        System.out.println("Gear at gearRules: " + gear);

        if (isEngineOn) {
            throw new IllegalStateException("Engine is already on. Please turn it off before starting it again.");
        }

        if (gear != Gear.NEUTRAL) {
            throw new IllegalStateException("Gear must be in neutral (0) to start the engine. Please shift to neutral before starting the engine.");
        }

        if (speed != 0) {
            throw new IllegalStateException("Speed must be 0 to start the engine. Please stop the car before starting the engine.");
        }
        
        return true;
    }

    protected boolean stopEngineRules(boolean isEngineOn, short gear, short speed) {

        if (!isEngineOn) {
            throw new IllegalStateException("Engine is already off. Please turn it on before stopping it.");
        }

        if (gear != 0) {
            throw new IllegalStateException("Gear must be in neutral (0) to stop the engine. Please shift to neutral before stopping the engine.");
        }

        if (speed != 0) {
            throw new IllegalStateException("Speed must be 0 to stop the engine. Please stop the car before stopping the engine.");
        }
        
        return true;
    }

    protected boolean accelerateSpeedRules(boolean isEngineOn, short speed, Gear currentGear, Gear newGear, GearAction action) {
        if (!isEngineOn) {
            throw new IllegalStateException("You need to start the engine before accelerating.");
        }

        if (speed >= 120) {
            throw new IllegalStateException("You have reached the maximum speed limit. Cannot accelerate further.");
        }

        boolean isRulesMet = changeGearRules(currentGear, (short) speed, action, newGear); // Using action of 2 (maintain gear) to skip the gear up/down validation, check only speed
        if (!isRulesMet) {
            throw new IllegalStateException("Cannot accelerate at the current speed and gear. Please check the speed and gear before accelerating.");
        }
        return true;
    }

    protected boolean reduceSpeedRules(boolean isEngineOn, short speed) {
        // There is no gear validation for reducing speed, as the driver can reduce speed in any gear. 
        // The gear validation is only necessary for accelerating, as the driver needs to be in the correct gear to accelerate at a certain speed.
        if (!isEngineOn) {
            throw new IllegalStateException("You need to start the engine before reducing the speed.");
        }

        if (speed <= 0) {
            throw new IllegalStateException("You have reached the minimum speed limit. Cannot reduce speed further.");
        }

        return true;
    }

    protected boolean changeGearRules(
        Gear currentGear,
        short speed,
        GearAction action,
        Gear newGear) {

        if (speed < 0 || speed > 120) {
            throw new IllegalStateException(
                "Speed must be between 0 and 120 km/h."
            );
        }

        // Maintain
        if (action == GearAction.MAINTAIN) {

            if (currentGear != newGear) {
                throw new IllegalStateException(
                    "Maintain action requires same gear."
                );
            }

            return true;
        }

        // Validate gear transition
        if (!currentGear.canShiftTo(newGear)) {
            throw new IllegalStateException(
                String.format(
                    "Cannot shift from %s to %s.",
                    currentGear,
                    newGear
                )
            );
        }

        // Validate action
        if (action == GearAction.SHIFT_UP &&
                newGear.getValue() <= currentGear.getValue()) {

            throw new IllegalStateException(
                "Shift up requires a higher gear, you can only move 1 at a time."
            );
        }

        if (action == GearAction.SHIFT_DOWN &&
                newGear.getValue() >= currentGear.getValue()) {

            throw new IllegalStateException(
                "Shift down requires a lower gear, you can only move 1 at a time."
            );
        }

        // Neutral and reverse can only be entered while stopped
        if ((newGear == Gear.NEUTRAL ||
                newGear == Gear.REVERSE) &&
                speed != 0) {

            throw new IllegalStateException(
                "Vehicle must be stopped to engage neutral or reverse."
            );
        }

        // Leaving neutral or reverse
        if ((currentGear == Gear.NEUTRAL ||
                currentGear == Gear.REVERSE) &&
                speed != 0) {

            throw new IllegalStateException(
                "Vehicle must be stopped before leaving neutral or reverse."
            );
        }

        // Validate speed for target gear
        if (!newGear.isValidSpeed(speed)) {

            throw new IllegalStateException(
                String.format(
                    "Speed %d km/h is invalid for gear %s. You need to change gear to keep this action.",
                    speed,
                    newGear
                )
            );
        }

        return true;
    }

}
