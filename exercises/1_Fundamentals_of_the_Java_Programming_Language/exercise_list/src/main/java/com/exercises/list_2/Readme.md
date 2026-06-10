## Exercises: list 2

Above a list of exercises to practice the concepts learned in the "Control Structures in Java" module.

- Personal note: Here I took the liberty of improving the base code from the exercise, adding more validations by the use of the separation of concerns principle, personalized messages, error handling, and somewhat more interactive than a simple input/output code.
- The original file can be found [here](https://github.com/digitalinnovationone/exercicios-java-basico/blob/main/exercicios/2%20-%20Estruturas%20de%20Controle%20em%20Java.MD)
- Note 1: For this series of exercises, I decided to implement a more robust input validation system, which result in a more complex code structure than the original exercises. This is intended to provide a more comprehensive learning experience, but it may require additional effort to understand the code. If you prefer a simpler implementation, feel free to refer to the original exercises or modify the code as needed.
- Note 2: The second list doen't work on and "infinty" loop for the options menu, like the first list. This happens due to the "throw new IllegalArgumentException" used, in a atempt to bring more robustness and practice with error handling. If you want to make it work on an infinity loop, you can replace the "throw new IllegalArgumentException" with a simple "System.err.println" and a "continue" statement, to keep the user in the options menu until they choose to exit.
- Note 3: The main methods for each operation is located on [GeneralMethods.java](GeneralMethods.md), and the main method for each exercise is located on the respective ex_1, ex_2, ex_3, and ex_4 packages. The code for each exercise is more complex than the original exercises, due to the added input validation and error handling. If you want to see a simpler implementation, please refer to the original exercises or modify the code as needed.

Get back to the [complete listing](../Readme.md) of exercises for the "Fundamentals of the Java Programming Language" module.

### Exercise 1

Write a code where the user enters a number and the multiplication table from 1 to 10 for that number is generated;

- Link to code explanation and code file in the [Readme](ex_1/Readme.md)

### Exercise 2

Write a code where the user enters their height and weight, their BMI is calculated (BMI = weight / (height \* height)), and a message is displayed according to the result:

- If it is less than or equal to 18.5 "Underweight";
- If it is between 18.6 and 24.9 "Ideal weight";
- If it is between 25.0 and 29.9 "Slightly overweight";
- If it is between 30.0 and 34.9 "Grade I Obesity";
- If it is between 35.0 and 39.9 "Grade II (Severe) Obesity";
- If it is greater than or equal to 40.0 "Grade III (Morbid) Obesity";

Link to code explanation and code file in the [Readme](ex_2/Readme.md)

### Exercise 3

Write a code where the user enters a first number, a second number greater than the first, and chooses between even and odd options; the code should then display all even or odd numbers (according to the initial selection) within the range of numbers entered, including the numbers entered, in descending order.

- Link to code explanation and code file in the [Readme](ex_3/Readme.md)

### Exercise 4

Write a code where the user inputs an initial number, then N other numbers. The code execution will continue until the number entered and divided by the first number results in a remainder other than 0. Numbers smaller than the first number should be ignored.

<!-- - Link to code explanation and code file in the [Readme](ex_4/Readme.md) -->
