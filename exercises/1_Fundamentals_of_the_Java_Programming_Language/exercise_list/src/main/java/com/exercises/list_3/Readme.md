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
