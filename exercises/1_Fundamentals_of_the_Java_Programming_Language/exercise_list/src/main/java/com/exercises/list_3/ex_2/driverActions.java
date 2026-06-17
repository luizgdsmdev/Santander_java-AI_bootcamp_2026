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

}
