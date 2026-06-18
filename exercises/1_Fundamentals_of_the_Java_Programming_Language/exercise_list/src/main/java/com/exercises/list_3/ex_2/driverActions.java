package main.java.com.exercises.list_3.ex_2;

public class driverActions extends carEngine{

    protected boolean startDriving() {
        try{
            if (!startEngine()) {return false;}
            return true;

        } catch (IllegalStateException e) {
            System.err.println("Something went wrong while trying to start driving: " + e.getMessage());
            return false;

        }
    }

    protected boolean stopDriving() {
        try{
            if (!stopEngine()) {return false;}
            return true;

        } catch (IllegalStateException e) {
            System.err.println("Something went wrong while trying to stop driving: " + e.getMessage());
            return false;

        }
    }

    protected Object[] accelerateDriver() {
        try{
            Object[] engineResponse = accelerateEngine();
            if (!(Boolean) engineResponse[0]) {
                throw new IllegalStateException((String) engineResponse[1]);
            }
            
            return engineResponse;

        } catch (IllegalStateException e) {
            return new Object[]{false, e.getMessage()};
        }
    }

    protected Object[] reduceDriver() {
        try{
            Object[] engineResponse = reduceEngine();
            if (!(Boolean) engineResponse[0]) {
                throw new IllegalStateException((String) engineResponse[1]);
            }
            
            return engineResponse;

        } catch (IllegalStateException e) {
            return new Object[]{false, e.getMessage()};
        }
    }

    protected Object[] changeGearDriver(short newGear) {
        try{
            Object[] engineResponse = changeGear(newGear);
            if (!(Boolean) engineResponse[0]) {
                throw new IllegalStateException((String) engineResponse[1]);
            }

            return engineResponse;

        } catch (IllegalStateException e) {
            return new Object[]{false, e.getMessage()};
        }
    }

    protected Object[] reduceGearDriver(short newGear) {
        try{
            Object[] engineResponse = reduceGear(newGear);
            if (!(Boolean) engineResponse[0]) {
                throw new IllegalStateException((String) engineResponse[1]);
            }

            return engineResponse;

        } catch (IllegalStateException e) {
            return new Object[]{false, e.getMessage()};
        }
    }
}
