## Exercise 1

Write code for a bank account that can perform the following operations:

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

### Personal note:

- The account was created separetely in its own class, so that it can be easyly used, alongside with the practical application ofabstraction and encapsulation concepts. The account class contains all the necessary attributes and methods to manage the bank account operations, while the main class is responsible for handling user input and providing a menu for the user to interact with the account. Check the whole class code at [BankAccount class](BankAccount.md).
- Persona note: I implemented the ability to have multiple accounts, and the user can choose which account they want to use, or create a new one. I also implemented input validation and error handling to ensure that the application runs smoothly and provides a good user experience. This may differ from the original requirements, but I believe it adds more value to the exercise and allows for a more comprehensive understanding of the concepts involved in managing a bank account.

Get back to the [listing 3](../Readme.md) of exercises for the "Fundamentals of the Java Programming Language" module.

## How it works

The code is structured in two classes: `Main` and `ex_9`. The `Main` class is responsible for initializing the application and creating a bank account, while the `ex_9` class contains the logic for managing the bank account operations, such as making deposits, checking balance, withdrawing money, and paying bills. The `ex_9` class also includes methods for handling user input and validating it to ensure that the operations are performed correctly. The user interacts with the application through a console-based menu, allowing them to choose different actions related to their bank account. The application continues to run until the user decides to exit by selecting the appropriate option from the menu.

Some of the methods used to do so are located in the [GeneralMethods](../GeneralMethods.md) class, which will be shared across all exercises in this listing, and also in the [ex_9](ex_9.java) class, and the [BankAccount](BankAccout.java) class, which contains the implementation of the bank account and its operations.

### `ex_9_BankAccount()` method

This method is responsible for initializing the application and creating the menu navigation between the different bank account operations. It contains the entry point of the application, and it calls the `ex_9_BankAccount()` method to start the bank account management process.

```java
    public void ex_9_BankAccount(){
        System.out.println("\n\nWelcome to the Bank Account Program! \nIf you wish to leave, just type 'exit' or 'quit' at any time.");
        boolean isValid = false;

        do{
            System.out.println("Check the options below: \n1. Create a new bank account \n2. Use an existing bank account");
            String userInput = getUserInput();
            isExit(userInput);

            switch (userInput) {
                case "1" -> {
                    BankAccout newAccount = createBankAccount();
                    useBankAccount(newAccount);
                }
                case "2" -> {
                    BankAccout selectedAccount = selectBankAccount();
                    if (selectedAccount != null) {
                        useBankAccount(selectedAccount);
                    }
                }
                default -> System.out.println("\nInvalid option. Please select one of the available options.");
            }
        }while (!isValid);

    }
```

#### `createBankAccount()` method

This method is responsible for creating a new bank account. It prompts the user to enter the account holder's name and age, validates the input, and then creates a new `BankAccout` object with the provided information. The new account is added to the list of accounts, and a success message is displayed to the user. If the input for age is invalid, an error message is shown, and the method returns null.

```java
    private BankAccout createBankAccount(){
        System.out.println("\nLet's create a new bank account! Please provide the following information:");
        System.out.print("Account Holder Name: ");
        String name = getUserInput();
        isExit(name);

        System.out.print("Account Holder Age: ");
        String age = getUserInput();
        isExit(age);
        Object[] ageValidation = inputTypeValidation(age, "short");


        if(!(boolean) ageValidation[0]){
            System.out.println("Invalid age input. Please enter a valid number for age.");
            return null;
        }

        BankAccout newAccount = new BankAccout(name, (short) ageValidation[1]);

        System.out.println("\nBank account created successfully for " + newAccount.getAccountHolderName() + " with account age " + newAccount.getAccountAge());
        accounts.add(newAccount);

        return newAccount;
    }
```

#### `selectBankAccount()` method

This method allows the user to select an existing bank account from the list of accounts. It first checks if there are any accounts available; if not, it prompts the user to create a new account. If accounts are available, it displays a list of accounts with their corresponding numbers and prompts the user to select one by entering the corresponding number. The input is validated to ensure it is an integer and corresponds to a valid account index. If the selection is valid, the selected `BankAccout` object is returned; otherwise, an error message is displayed, and null is returned.

```java
    private BankAccout selectBankAccount(){
        if (accounts.isEmpty()) {
            System.out.println("\nNo bank accounts available. Please create a new bank account first.\n");
            return null;
        }

        System.out.println("Available bank accounts:");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println((i + 1) + ". " + accounts.get(i).getAccountHolderName() + "'s account");
        }

        System.out.print("Select the account you want to use: ");
        String accountSelection = getUserInput();
        isExit(accountSelection);

        Object[] accountIndex = inputTypeValidation(accountSelection, "integer");
        if (!(boolean) accountIndex[0]) {
            System.out.println("\nInvalid account selection.");
            return null;
        }

        //Correct's the index to match the list's index, since the user sees the options starting from 1, but the list starts from 0.
        int index = (int) accountIndex[1] - 1;
        if(index < 0 || index >= accounts.size()){
            System.out.println("\nInvalid account selection.");
            return null;
        }

        return accounts.get(index);
    }
```

#### `useBankAccount(BankAccout account)` method

This method is responsible for managing the operations of a selected bank account. It displays a menu of options to the user, allowing them to choose between making a deposit, checking the balance, withdrawing money, or returning to the main menu. The user's input is validated, and based on the selection, the corresponding method is called to perform the desired operation on the bank account. After each operation, the menu is displayed again until the user decides to return to the main menu or exit the application.

```java
    private void useBankAccount(BankAccout account){

        System.out.println("What would you like to do? Current account: " + account.getAccountHolderName() + " \n0. return to the main menu \n1. Make a deposit \n2. Check balance \n3. Withdraw money");
        String userInput = getUserInput();
        isExit(userInput);

        switch (userInput) {
            case "0" -> {
                ex_9_BankAccount();
            }
            case "1" -> {
                makeDeposit(account);
                useBankAccount(account);
            }
            case "2" -> {
                System.out.println("Your balance is: R$" + account.getBalance());
                useBankAccount(account);
            }
            case "3" -> {
                withdrawMoney(account);
                useBankAccount(account);
            }
            default -> {
                System.out.println("\nInvalid option. Please select one of the available options.");
                useBankAccount(account);
            }
        }
    }
```

#### `makeDeposit(BankAccout account)` method

This method is responsible for handling the deposit operation for a given bank account. It prompts the user to enter the amount they wish to deposit, validates the input to ensure it is a valid number, and then calls the `makeDeposit` method of the `BankAccout` class to perform the deposit. If the deposit is successful, it displays a success message along with the updated balance. If there is an issue with processing the deposit, it shows an error message. The method also includes exception handling to catch any unexpected errors that may occur during the deposit process.

```java
    private void makeDeposit(BankAccout account){
        try{
            System.out.print("Enter the amount to deposit: ");
            String depositAmount = getUserInput();
            isExit(depositAmount);

            Object[] amountValidation = inputTypeValidation(depositAmount, "double");
            if (!(boolean) amountValidation[0]) {
                System.out.println("\nInvalid deposit amount. Please enter a valid number.");
            }

            if (account.makeDeposit((double) amountValidation[1])) {
                System.out.println("Deposit made successfully. Your balance is now: R$" + account.getBalance());

            } else{
                System.out.println("Something went wrong while processing the deposit.");

            }
        }catch(Exception e){
            System.err.println("Something went wrong while processing the deposit: " + e.getMessage());
        }
    }
```

#### `withdrawMoney(BankAccout account)` method

This method is responsible for handling the withdrawal operation for a given bank account. It prompts the user to enter the amount they wish to withdraw, validates the input to ensure it is a valid number, and then calls the `makeWithdrawal` method of the `BankAccout` class to perform the withdrawal. If the withdrawal is successful, it displays a success message along with the updated balance. If there are insufficient funds for the withdrawal, it shows an error message indicating the current balance and overdraft limit. The method also includes exception handling to catch any unexpected errors that may occur during the withdrawal process.

```java
    private void withdrawMoney(BankAccout account){
        try{
            System.out.print("Enter the amount to withdraw: ");
            String withdrawalAmount = getUserInput();
            isExit(withdrawalAmount);

            Object[] amountValidation = inputTypeValidation(withdrawalAmount, "double");
            if (!(boolean) amountValidation[0]) {
                System.out.println("\nInvalid withdrawal amount. Please enter a valid number.");
                return;
            }

            Object[] withdrawalResult = account.makeWithdrawal((double) amountValidation[1]);
            if ((boolean) withdrawalResult[0]) {
                System.out.println("Withdrawal made successfully. Your balance is now: R$" + withdrawalResult[1]);
            }

        }catch(Exception e){
            System.err.println("Something went wrong while processing the withdrawal: " + e.getMessage());
            return;
        }
    }
```
