package main.java.com.exercises.list_3.ex_2;

public class carRules{

    protected boolean startEngineRules(boolean isEngineOn, short gear, double speed) {

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

    protected boolean stopEngineRules(boolean isEngineOn, short gear, double speed) {

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

}
