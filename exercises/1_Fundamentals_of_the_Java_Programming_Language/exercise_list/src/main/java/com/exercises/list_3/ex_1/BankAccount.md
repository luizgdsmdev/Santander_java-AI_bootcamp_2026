## BankAccount class

This class represents a bank account with attributes such as account holder name, balance, and overdraft limit. It provides methods for making deposits, checking the balance, and making withdrawals while considering the overdraft limit.

### How it works

- The constructor initializes the account with the account holder's name and the initial deposit amount. It also calculates the overdraft limit based on the initial deposit.
- The `makeDeposit` method allows the user to deposit money into the account, updating the balance accordingly.
- The `getBalance` method returns the current balance of the account.
- The `makeWithdrawal` method allows the user to withdraw money from the account, considering the overdraft limit. It updates the balance accordingly.
- The `getOverdraftLimit` method returns the overdraft limit of the account.
- The `getAccountHolderName` method returns the name of the account holder.
  And so on. The class is designed to encapsulate the properties and behaviors of a bank account, allowing for easy management of the account's state and operations.

#### BankAccout constructor

The constructor initializes the account with the account holder's name and age, as minimum requirements for a bank account.

```java
    BankAccout(String name, short age) {
        this.accountHolderName = name;
        this.accountAge = age;
    }
```

#### accountHolderName

Simple getter and setter for the account holder's name. Used most in the class as a way to identify the account, since there is no account number or other unique identifier implemented. Used in the constructor to set the name of the account holder, which is a requirement for creating a bank account.

```java
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

```

#### accountAge

Simple getter and setter for the account holder's age. Used in the constructor to set the age of the account holder, which is a requirement for creating a bank account. It can also be used to implement age-related features or restrictions in the future, such as limiting certain operations for underage account holders or providing special benefits for senior account holders.

```java
    public short getAccountAge() {
        return accountAge;
    }

    public void setAccountAge(short accountAge) {
        this.accountAge = accountAge;
    }
```

#### balance

Simple getter and setter for the account balance. Used to get the current balance of the account and to update the balance after making deposits or withdrawals. The setter method is designed to add the deposited amount to the existing balance, rather than replacing it, which allows for multiple deposits to be made without losing the previous balance. This design choice ensures that the balance is always accurate and reflects all transactions made on the account.

```java
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance += balance;
    }

```

#### overdraftLimit

Simple getter and setter for the overdraft limit. The getter method allows other parts of the program to access the overdraft limit, while the setter method is private, meaning it can only be called within the BankAccount class. This design choice ensures that the overdraft limit can only be set during account creation or through specific methods within the class, preventing unauthorized changes to the overdraft limit from outside the class. The overdraft limit is calculated based on the initial deposit amount, and it is set when the first deposit is made, ensuring that it is always consistent with the account's initial conditions.

```java
    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    private void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }
```

#### makeDeposit method

This method allows the user to deposit money into the account. It takes the deposit amount as a parameter and updates the account balance accordingly. The method also checks if the deposit is the first one made to the account, and if so, it sets the overdraft limit based on the initial deposit amount. If the deposit amount is invalid (e.g., negative or zero), it throws an IllegalArgumentException, which is caught and handled within the method to provide feedback to the user.

```java
    public boolean makeDeposit(double amount) {
        //The amount value is already validated in the main method, that's why I don't need to add further validation logic here.
        try{
            if (amount <= 0) {
                throw new IllegalArgumentException("Invalid deposit amount.");
            }

            if(isFirstDeposit(amount)){
                System.out.println("First deposit made successfully. Your overdraft limit was set to: R$" + getOverdraftLimit());
                setBalance(amount);
                return true;
            }

            setBalance(amount);
            return true;

        } catch (IllegalArgumentException e) {
            System.err.println("Something went wrong while processing the deposit: " + e.getMessage());
            return false;
        }
    }
```

#### makeWithdrawal method

This method allows the user to withdraw money from the account. It takes the withdrawal amount as a parameter and updates the account balance accordingly, whithout considering the overdraft limit, which is handled in a different method. If the withdrawal amount is invalid (e.g., negative or zero) or if there are insufficient funds for the withdrawal, it throws an IllegalArgumentException, which is caught and handled within the method to provide feedback to the user. The method returns an array of objects, where the first element indicates whether the withdrawal was successful (true or false), and the second element provides the updated balance after the withdrawal attempt.

```java
    public Object[] makeWithdrawal(double amount) {
        //The amount value is already validated in the main method, that's why I don't need to add further validation logic here.
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Invalid withdrawal amount.");
            }

            if (amount > getBalance()) {
                throw new IllegalArgumentException("Insufficient funds for withdrawal. Check option 'Use overdraft' to verify your total balance.");
            }

            setBalance(-amount);
            return new Object[]{true, getBalance()};

        } catch (IllegalArgumentException e) {
            System.err.println("Something went wrong while processing the withdrawal: " + e.getMessage());
            return new Object[]{false, getBalance()};
        }
    }
```

#### isFirstDeposit method

This method checks if the deposit being made is the first one for the account. If it is the first deposit, it sets the overdraft limit based on the amount deposited. If the deposit amount is R$500.00 or less, the overdraft limit is set to R$50.00; for amounts above R$500.00, the overdraft limit is set to 50% of the deposited amount. The method returns true if it was the first deposit and false otherwise.

```java
    private boolean isFirstDeposit(double amount) {
        if (this.firstDepositMade) {
            this.firstDepositMade = false;

                if (amount <= 500) {
                    setOverdraftLimit(50.0); //overdraftLimit = 50.0;
                } else {
                    setOverdraftLimit(amount * 0.5); //overdraftLimit = amount * 0.5;
                }

            return true;
        }
        return false;
    }
```
