package main.java.com.exercises.list_3.ex_2;

import main.java.com.exercises.list_3.GeneralMethods;

public class ex_10 extends GeneralMethods {

    private void startNewDrive() {
        System.out.println("\nStarting a new drive... \nRemember to always follow the car rules and driver actions for a safe and enjoyable experience!");
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