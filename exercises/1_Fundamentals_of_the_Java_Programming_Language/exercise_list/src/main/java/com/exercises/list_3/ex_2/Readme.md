## Exercise 2

Write code that controls the functions of a car. It should have the following functions:

- Start the car;
- Turn off the car;
- Accelerate;
- Decrease speed;
- Turn left/right;
- Check speed;
- Change gear
- Follow these implementation rules:
- When the car is created, it must start off, in neutral, and with its speed at 0;
- The car cannot perform any functions when turned off;
- When the car stops while accelerating, it must increment its speed by 1 km/h (it can reach a maximum of 120 km/h);
- When the car decreases its speed, it must decrement its speed by 1 km/h (it can reach a minimum of 0 km/h);
- The car must have 6 gears; skipping gears is not allowed.
- The car's speed must respect the following limits for each speed:
  - If the car is in neutral (0), it cannot accelerate.
  - If you are in 1st gear, your speed can be between 0km and 20km.
  - If you are in 2nd gear, your speed can be between 21km and 40km.
  - If you are in 3rd gear, your speed can be between 41km and 60km.
  - If you are in 4th gear, your speed can be between 61km and 80km.
  - If you are in 5th gear, your speed can be between 81km and 100km.
  - If you are in 6th gear, your speed can be between 101km and 120km.
- The car can be turned off if it is in neutral (0) and its speed is 0 km.
- The car can only turn left/right if its speed is at least 1km and at most 40km.

Get back to the [listing 3](../Readme.md) of exercises for the "Fundamentals of the Java Programming Language" module.

## How it works

The code is structured in two classes: `Main` and `ex_10`. The `Main` class is responsible for initializing the application and creating a car, while the `ex_10` class contains the logic for managing the car operations, such as starting the car, accelerating, decreasing speed, turning left/right, and changing gears. The `ex_10` class also includes methods for handling user input and validating it to ensure that the operations are performed correctly. The user interacts with the application through a console-based menu, allowing them to choose different actions related to their car. The application continues to run until the user decides to exit by selecting the appropriate option from the menu.

- The `ex_10` class will only be able to interact with the `driverActions` class, that will be responsible for the actions that the driver can perform, such as accelerating, decreasing speed, and turning left/right.
- The `driverActions` class will only be able to interact with the `carEngine` class, which will be responsible for managing the state of the car, such as whether it is on or off, and its current speed.
- The `carEngine` class will only be able to interact with the `carRules` class will contain the rules that govern how the car can be operated, such as the speed limits for each gear and the conditions for turning left/right.

Some of the methods used to do so are located in the [GeneralMethods](../GeneralMethods.md) class, which will be shared across all exercises in this listing, and also in the [ex_10](ex_10.java) class, and the [Car](Car.java) class, which contains the implementation of the car and its operations.

### `ex_10_carDrive()` method
