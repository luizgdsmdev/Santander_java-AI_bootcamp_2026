package main.java.com.exercises.list_3.ex_2;
public class carEngine extends carRules{

    private boolean isEngineOn = false;
    private boolean isCarMoving = false;
    private boolean isTurningLeft = false;
    private boolean isTurningRight = false;
    private double speed = 0.0;
    private short gear = 0;
    private boolean isStraight = false;
    private boolean reverse = false;

    private boolean isEngineOn() {
        return isEngineOn;
    }

    private void setEngineOn() {
        this.isEngineOn = true;
    }

    private void setEngineOff() {
        this.isEngineOn = false;
    }
    
    private boolean isCarMoving() {
        return this.isCarMoving;
    }

    private void setCarMoving() {
        this.isCarMoving = true;
    }

    private void setCarStopped() {
        this.isCarMoving = false;
    }

    private boolean isTurningLeft() {
        return this.isTurningLeft;
    }

    private void setTurningLeft() {
        this.isTurningLeft = true;
    }

    private boolean isTurningRight() {
        return this.isTurningRight;
    }

    private void setTurningRight() {
        this.isTurningRight = true;
    }

    private boolean isStraight() {
        return this.isStraight;
    }

    private void setStraight() {
        this.isTurningLeft = false;
        this.isTurningRight = false;
        this.isStraight = true;
    }

    private boolean isReverse() {
        return this.isReverse;
    }
    
    private void setReverse() {
        this.isStraight = false;
        this.isReverse = true;
    }

    private double getSpeed() {
        return this.speed;
    }

    private void setSpeed(double speed) {
        this.speed = speed;
    }

    private short getGear() {
        return this.gear;
    }

    private void setGear(short gear) {
        this.gear = gear;
    }


    // Methods list

    /**
     * @Description: This method is responsible for starting the engine of the car. It checks if the engine is already on, if the gear is in neutral, and if the speed 
     * is 0 before allowing the engine to start. If any of these conditions are not met, it throws an IllegalStateException with an appropriate message. 
     * If all conditions are met, it sets the engine on.
     * @Throws: IllegalStateException if the engine is already on, if the gear is not in neutral, or if the speed is not 0.
     * @Returns: void
     */
    protected boolean startEngine() {
        try{
            boolean isRulesMet = startEngineRules(isEngineOn(), getGear(), getSpeed());
            if (isRulesMet) { setEngineOn(); }
            return true;

        } catch (IllegalStateException e) {
            System.err.println("Something went wrong while trying to start the engine: " + e.getMessage());
            return false;
        }
    }

    protected boolean stopEngine() {
        try{
            boolean isRulesMet = stopEngineRules(isEngineOn(), getGear(), getSpeed());
            if (isRulesMet) { setEngineOff(); }
            return true;

        } catch (IllegalStateException e) {
            System.err.println("Something went wrong while trying to stop the engine: " + e.getMessage());
            return false;
        }
    }


}
