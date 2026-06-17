# Exercises: list 3

Above a list of exercises to practice the concepts learned in the "Control Structures in Java" module.

- Personal note: Here I took the liberty of improving the base code from the exercise, adding more validations by the use of the separation of concerns principle, personalized messages, error handling, and somewhat more interactive than a simple input/output code.
- The original file can be found [here](https://github.com/digitalinnovationone/exercicios-java-basico/blob/main/exercicios/3%20-%20Java%20e%20a%20Arte%20da%20Abstra%C3%A7%C3%A3o%20com%20Classes%20e%20Encapsulamento.md)
- Note 1: For this series of exercises, I decided to implement a more robust input validation system, which result in a more complex code structure than the original exercises. This is intended to provide a more comprehensive learning experience, but it may require additional effort to understand the code. If you prefer a simpler implementation, feel free to refer to the original exercises or modify the code as needed.
- Note 3: The main methods for each operation is located on [GeneralMethods.java](GeneralMethods.md), and the main method for each exercise is located on the respective ex_1, ex_2, ex_3, and ex_4 packages. The code for each exercise is more complex than the original exercises, due to the added input validation and error handling. If you want to see a simpler implementation, please refer to the original exercises or modify the code as needed.

Get back to the [complete listing](../Readme.md) of exercises for the "Fundamentals of the Java Programming Language" module.

## All exercises must have an interactive menu to call the functions and an exit option to end execution.

### Exercise 1

1. Write code for a bank account that can perform the following operations:

- Check balance
- Check overdraft
- Deposit money;
- Withdraw money;
- Pay a bill.
- Check if the account is using overdraft.

Follow these rules to implement:

- The bank account must have an overdraft limit added to the account balance;
- The overdraft amount is defined at the time of account creation, according to the amount deposited into the account at its creation;
- If the amount deposited at account creation is R$500.00 or less, the overdraft should be R$50.00;
- For amounts above R$500.00, the overdraft should be 50% of the deposited amount;
- If the overdraft facility is used, the account must charge a fee of 20% of the overdraft amount used as soon as possible.

Link to code explanation and code file in the [Readme](ex_1/Readme.md)

---

### Exercise 2

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

Link to code explanation and code file in the [Readme](ex_2/Readme.md)
