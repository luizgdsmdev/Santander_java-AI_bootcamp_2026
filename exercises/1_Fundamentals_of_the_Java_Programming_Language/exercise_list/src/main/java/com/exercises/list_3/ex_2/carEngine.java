package main.java.com.exercises.list_3.ex_2;

public class carEngine extends carRules{

    private boolean isEngineOn = false;
    private boolean isCarMoving = false;
    private boolean isTurningLeft = false;
    private boolean isTurningRight = false;
    private short speed = 0;
    private boolean isStraight = false;
    private Gear currentGear = Gear.NEUTRAL;


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
        return this.currentGear == Gear.REVERSE;
    }
    
    private void setReverse() {
        this.isStraight = false;
        this.currentGear = Gear.REVERSE;
    }

    private short getSpeed() {
        return this.speed;
    }

    private void setSpeed(short speed) {
        this.speed = speed;
    }

    private Gear getGear() {
        System.out.println("Getting gear: " + this.currentGear);
        return this.currentGear;
    }

    private void setGear(Gear gear) {
        System.out.println("Setting gear: " + gear);
        this.currentGear = gear;
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
            if (isRulesMet) { 
                setGear(Gear.NEUTRAL);
                setEngineOn();
                setSpeed((short) 0);
                return true;
            }

            return false;

        } catch (IllegalStateException e) {
            System.err.println("Something went wrong while trying to start the engine: " + e.getMessage());
            return false;
        }
    }

    /**
     * @Description: This method is responsible for stopping the engine of the car. It checks if the engine is already off, if the gear is in neutral, and if the speed 
     * is 0 before allowing the engine to stop. If any of these conditions are not met, it throws an IllegalStateException with an appropriate message. 
     * If all conditions are met, it sets the engine off.
     * @Throws: IllegalStateException if the engine is already off, if the gear is not in neutral, or if the speed is not 0.
     * @Returns: void
     */
    protected boolean stopEngine() {
        try{
            boolean isRulesMet = stopEngineRules(isEngineOn(), getGear(), getSpeed());
            if (isRulesMet) { 
                setEngineOff();
                setGear((short) 0);
                setSpeed((short) 0);
                return true;
             }
            return false;

        } catch (IllegalStateException e) {
            System.err.println("Something went wrong while trying to stop the engine: " + e.getMessage());
            return false;
        }
    }

    protected Object[] accelerateEngine() {
        try{
            boolean isRulesMet = accelerateSpeedRules(isEngineOn(), getSpeed(), getGear());

            if (isRulesMet) {
                setSpeed((short) (getSpeed() + 1));
                setCarMoving();
                return new Object[]{true, getSpeed()};
            }

            return new Object[]{false, "Engine is off"};

        }catch (IllegalStateException e) {
            return new Object[]{false, e.getMessage()};
        }

    }

    protected Object[] reduceEngine() {
        try{
            boolean isRulesMet = reduceSpeedRules(isEngineOn(), getSpeed());

            if (isRulesMet) {
                setSpeed((short) (getSpeed() - 1));

                if (getSpeed() == 0) { setCarStopped(); }

                setCarMoving();
                return new Object[]{true, getSpeed()};
            }

            return new Object[]{false, "Engine is off"};

        }catch (IllegalStateException e) {
            return new Object[]{false, e.getMessage()};
        }

    }

    protected Object[] changeGear(short newGear) {
        try{
            boolean isRulesMet = changeGearRules((short) getGear(), (short) getSpeed(), (short) 0, newGear);

            if (isRulesMet) {
                setGear(newGear);
                return new Object[]{true, getGear()};
            }

            return new Object[]{false, "Failed to change gear. Please check the rules and try again."};

        }catch (IllegalStateException e) {
            System.err.println("Something went wrong while trying to change gear: " + e.getMessage());
            return new Object[]{false, e.getMessage()};
        }
    }

        protected Object[] reduceGear(short newGear) {
        try{
            boolean isRulesMet = changeGearRules((short) getGear(), (short) getSpeed(), (short) 1, newGear);

            if (isRulesMet) {
                setGear(newGear);
                return new Object[]{true, getGear()};
            }

            return new Object[]{false, "Failed to reduce gear. Please check the rules and try again."};

        }catch (IllegalStateException e) {
            System.err.println("Something went wrong while trying to reduce the gear: " + e.getMessage());
            return new Object[]{false, e.getMessage()};
        }
    }
}
