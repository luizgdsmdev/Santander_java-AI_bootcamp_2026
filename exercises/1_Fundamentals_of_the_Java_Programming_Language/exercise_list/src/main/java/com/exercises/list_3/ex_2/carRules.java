package main.java.com.exercises.list_3.ex_2;

public class carRules{

    protected boolean startEngineRules(boolean isEngineOn, short gear, short speed) {

        if (isEngineOn) {
            throw new IllegalStateException("Engine is already on. Please turn it off before starting it again.");
        }

        if (gear != 0) {
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

    protected boolean changeGearRules(short gear, short speed, short action, short newGear) {
        // Engine must be on, validated at accelerateSpeedRules before calling this method.
        // Geers min = 0, max = 6
        // Speed min = 0, max = 120

        // Action: 0 = shift up, 1 = shift down, 2 = maintain gear
        if((action == 0) && (gear + 1 != newGear)) {
            throw new IllegalStateException("To shift up, you need to shift to the next gear. Please check the current gear and the new gear before shifting up.");
        }

        if((action == 1) && (gear - 1 != newGear)) {
            throw new IllegalStateException("To shift down, you need to shift to the previous gear. Please check the current gear and the new gear before shifting down.");
        }
        
        if (gear < 0 || gear > 6) {
            throw new IllegalStateException("Gear must be between 0 and 6.");
        }

        if (speed < 0 || speed > 120) {
            throw new IllegalStateException("Speed must be between 0 and 120.");
        }

        if (gear == 0 && speed != 0) {
            throw new IllegalStateException("Cannot shift to neutral (0) while the car is moving. Please stop the car before shifting to neutral.");
        }

        if (gear == 6 && speed != 0) {
            throw new IllegalStateException("Cannot shift to reverse (6) while the car is moving. Please stop the car before shifting to reverse.");
        }

        if(gear == 1 && speed > 24) {
            throw new IllegalStateException("Cannot shift to gear 1 at speeds above 24. Please check speed before shifting to gear 1.");
        }

        if(gear == 2 && (speed > 48 || speed < 25)) {
            throw new IllegalStateException("Cannot shift to gear 2 at speeds below to 24 and above 48. Please check speed before shifting to gear 2.");
        }

        if(gear == 3 && (speed > 72 || speed < 49)) {
            throw new IllegalStateException("Cannot shift to gear 3 at speeds below to 48 and above 72. Please check speed before shifting to gear 3.");
        }

        if(gear == 4 && (speed > 96 || speed < 73)) {
            throw new IllegalStateException("Cannot shift to gear 4 at speeds below to 72 and above 96. Please check speed before shifting to gear 4.");
        }

        if(gear == 5 && (speed > 120 || speed < 97)) {
            throw new IllegalStateException("Cannot shift to gear 5 at speeds below to 96 and above 120. Please check speed before shifting to gear 5.");
        }

        if(gear == 6 && speed > 120) {
            throw new IllegalStateException("Cannot shift to reverse (6) at speeds above 120. Please check speed before shifting to reverse.");
        }

        return true;
    }

    protected boolean accelerateSpeedRules(boolean isEngineOn, short speed, short gear) {
        if (!isEngineOn) {
            throw new IllegalStateException("You need to start the engine before accelerating.");
        }

        if (speed >= 120) {
            throw new IllegalStateException("You have reached the maximum speed limit. Cannot accelerate further.");
        }

        boolean isRulesMet = changeGearRules(gear, (short) speed, (short) 2, (short) 0); // Using action of 2 (maintain gear) to skip the gear up/down validation, check only speed
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

}
