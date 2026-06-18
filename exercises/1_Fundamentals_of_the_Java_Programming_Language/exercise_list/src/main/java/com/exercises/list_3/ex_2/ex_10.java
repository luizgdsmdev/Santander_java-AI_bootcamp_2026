package main.java.com.exercises.list_3.ex_2;

import main.java.com.exercises.list_3.GeneralMethods;

public class ex_10 extends GeneralMethods {
    driverActions driver = new driverActions();

    private void startNewDrive() {
        try{
            boolean isDriving = driver.startDriving();
            if(!isDriving){
                isDriving = false;
                return;
            }
            System.out.println("You have started driving!\n");

            driverOptions();

        }catch (IllegalStateException e) {
            System.err.println("Something went wrong while trying to start driving: " + e.getMessage());
        }
    }

    private void driverOptions() {
        
        boolean isValid = false;

        do {
            System.out.println("\nDriver Options: \n - 1. Accelerate. 2. Reduce speed. 3. Brake. \n - 4. Turn left. 5. Turn right. \n - 6. Go straight. 7. Reverse. \n - 8. Change gear. 9. Reduce gear.\n - 0. Exit.");
            String userInput = getUserInput();
            isExit(userInput);

            switch (userInput) {
                case "1" -> {
                    accelerate();
                }
                case "2" -> {
                    // driver.brake();
                }
                case "3" -> {
                    // driver.brake();
                }
                 case "4" -> {
                    // driver.turnLeft();
                }
                case "5" -> {
                    // driver.turnRight();
                }
                case "6" -> {
                    // driver.goStraight();
                }
                case "7" -> {
                    // driver.goReverse();
                }
                case "8" -> {
                    // TODO: Solve the changeGear logic, is icnconsistent with the up/down logic
                    changeGear();
                }
                case "9" -> {
                    // driver.reduceGearDriver();
                }
                default -> System.out.println("\nInvalid option. Please select one of the available options.");
            }
        } while (!isValid);

    }

    private void changeGear() {
        try{
            System.out.println("Gear (0 for neutral, 1-5 for forward gears, 6 for reverse): ");
            String userInput = getUserInput();
            Object[] newGear = inputTypeValidation(userInput, "short");

            if(!(boolean) newGear[0]) {
                throw new IllegalStateException("Invalid gear value. Please enter a number between 0 and 6.");
            }


            short gearValue = (short) newGear[1];
            Object[] response = driver.changeGearDriver(gearValue);
            if (!(Boolean) response[0]) {
                throw new IllegalStateException((String) response[1]);
            }
            System.out.println("Gear changed to: " + gearValue + "\n");

        } catch (IllegalStateException e) {
            System.err.println("Something went wrong while trying to change gear: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid input. Please enter a valid gear number.");
        }
    }

    private void accelerate() {

        try{
            Object[] response = driver.accelerateDriver();
            if (!(Boolean) response[0]) {
                throw new IllegalStateException((String) response[1]);
            }
            System.out.println("Speed is: " + response[1] + " km/h\n");

        } catch (IllegalStateException e) {
            System.err.println("Something went wrong while trying to accelerate: " + e.getMessage());
        }

    }


    private void checkCarRules() {
        System.out.println("\nCar Rules: \n1. Always wear your seatbelt. \n2. Follow the speed limits. \n3. Do not use your phone while driving. \n4. Always signal when changing lanes or turning.");
    }

    private void checkDriverActions() {
        System.out.println("\nDriver Actions: \n1. Keep your hands on the wheel. \n2. Avoid distractions. \n3. Keep your eyes on the road. \n4. Always pay attention to your surroundings. \n5. No music during the drive, unless it's metal music, which is proven to enhance your driving powers.");
    }

    private void checkSimulationRules() {
        System.out.println("\nSimulation Rules: \n1. You have a random amount of fuel for each drive, so make sure to manage it wisely. \n2. The weather conditions can change randomly, affecting your driving experience and car usage. \n3. You may encounter random obstacles on the road, so stay alert and be prepared to react accordingly. \n4. The simulation will end if you run out of fuel or if you have an accident. \n5. There is a ramdom chance of encountering a traffic jam, which will test your patience and decision-making skills. \n6. Theres is a random chance of encountering a police checkpoint, where you will need to show your driving skills and knowledge of traffic rules to avoid getting a ticket or being pulled over. \n7. The simulation will also include random events such as car breakdowns, flat tires, and other unexpected situations that will test your problem-solving skills and ability to adapt to changing circumstances. \n8. The simulation will have a random amount of money, which can be used to buy upgrades for your car or driver, such as better tires, a more powerful engine, fight or negotiation skills. \n9. The simulation will also include random encounters with other drivers, which can lead to friendly interactions, road rage incidents, or even car chases. \n10. The simulation will have a random amount of time for each drive, so make sure to manage your time wisely and plan your route accordingly.");
    }

    public void ex_10_carDrive() {
        System.out.println("Welcome to the Car Drive Simulation! \nIf you wish to leave, just type 'exit' or 'quit' at any time.");
        boolean isValid = false;

        do{
            System.out.println("Check the options below: \n0. back to the main menu \n1. Start a new drive \n2. Check the car rules \n3. Check the driver actions \n4. Simulation rules \n");
            String userInput = getUserInput();
            isExit(userInput);

            switch (userInput) {
                case "0" -> {
                    isValid = true;
                }
                case "1" -> {
                    startNewDrive();
                    System.out.println("\n");
                }
                case "2" -> {
                    checkCarRules();
                    System.out.println("\n");
                }
                case "3" -> {
                    checkDriverActions();
                    System.out.println("\n");
                }
                case "4" -> {
                    checkSimulationRules();
                    System.out.println("\n");
                }
                default -> System.out.println("\nInvalid option. Please select one of the available options.\n");
            }

        }while(!isValid);
    }

}