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

    public double getTotalBalance(){
        return this.balance + this.overdraftLimit;
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

    private double getOverdraftFee(double amount) {
        return amount * 0.2; // 20% fee on the overdraft amount, according to the exercise requirements.

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
                throw new IllegalArgumentException("Insufficient funds for withdrawal.");
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

#### getPaymentHistory() method

This method returns the payment history of the account, which is stored as a list of object arrays. Each object array contains information about a payment, such as the payment ID and the amount. The method allows other parts of the program to access the payment history for display or further processing.

```java
    public List<Object[]> getPaymentHistory() {
        return paymentHistory;
    }
```

#### addPaymentHistory(String paymentId, double amount) method

This method adds a new payment entry to the payment history list. It takes a payment ID and an amount as parameters, creates an object array with this information, and adds it to the payment history list. This method is typically called after a successful payment transaction to keep a record of the payment details.

```java
    public void addPaymentHistory(String paymentId, double amount) {
        this.paymentHistory.add(new Object[]{paymentId, amount});
    }
```

#### makeOverdraftWithdrawal(double amount) method

This method allows the user to make a withdrawal that exceeds the current balance, utilizing the overdraft limit. It takes the withdrawal amount as a parameter and calculates the total amount to be withdrawn, including any applicable overdraft fees. The method checks if the total withdrawal amount exceeds the overdraft limit, and if so, it throws an IllegalArgumentException. If the withdrawal is successful, it updates the overdraft limit accordingly and returns an array of objects indicating whether the withdrawal was successful and the updated overdraft limit. If there is an error during the process, it catches the exception and returns an array indicating that the withdrawal was unsuccessful along with the current overdraft limit.

```java
    public Object[] makeOverdraftWithdrawal(double amount) {
        //The amount value is already validated in the main method, that's why I don't need to add further validation logic here.
        try {
            amount += getOverdraftFee(amount);
            if (amount <= 0) {
                throw new IllegalArgumentException("Invalid withdrawal amount.");
            }

            if (amount > getOverdraftLimit()) {
                throw new IllegalArgumentException("Withdrawal amount exceeds overdraft limit and fees.");
            }

            setOverdraftLimit(-amount);
            return new Object[]{true, getOverdraftLimit()};

        } catch (IllegalArgumentException e) {
            System.err.println("Something went wrong while processing the withdrawal: " + e.getMessage());
            return new Object[]{false, getOverdraftLimit()};
        }
    }
```

#### makeCombinedWithdrawal(double balance, double overdraft) method

This method allows the user to make a withdrawal that combines both the current balance and the overdraft limit. It takes the withdrawal amount for the balance and the overdraft as parameters, calculates the total amount to be withdrawn including any applicable overdraft fees, and checks if the total withdrawal amount exceeds the combined limits. If the withdrawal is successful, it updates both the balance and the overdraft limit accordingly and returns an array of objects indicating whether the withdrawal was successful, along with the updated balance and overdraft limit. If there is an error during the process, it catches the exception and returns an array indicating that the withdrawal was unsuccessful along with the current balance and overdraft limit.

```java
    public Object[] makeCombinedWithdrawal(double balance, double overdraft) {
        //The amount value is already validated in the main method, that's why I don't need to add further validation logic here.
        try {
            overdraft += getOverdraftFee(overdraft);
            if (balance <= 0) {throw new IllegalArgumentException("Invalid balance amount.");}

            if (balance > getBalance()) {throw new IllegalArgumentException("Balance amount exceeds total balance limit.");}

            if (overdraft <= 0) {throw new IllegalArgumentException("Invalid overdraft amount.");}

            if (overdraft > getOverdraftLimit()) {throw new IllegalArgumentException("Overdraft amount exceeds overdraft limit and fees.");}

            setBalance(-balance);
            setOverdraftLimit(-overdraft);

            return new Object[]{true, getBalance(), getOverdraftLimit()};

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Something went wrong while processing the withdrawal at makeCombinedWithdrawal method: " + e.getMessage());
        }
    }
```

#### makeAutoWithdrawal(double amount) method

This method allows the user to make a withdrawal that automatically determines whether to use the balance, the overdraft, or a combination of both based on the withdrawal amount. It takes the withdrawal amount as a parameter, checks if it exceeds the current balance, and if so, it calculates how much of the withdrawal can be covered by the balance and how much needs to be covered by the overdraft. It also calculates any applicable overdraft fees and checks if the total withdrawal amount exceeds the combined limits. If the withdrawal is successful, it updates both the balance and the overdraft limit accordingly and returns an array of objects indicating whether the withdrawal was successful, along with the updated balance and overdraft limit. If there is an error during the process, it catches the exception and returns an array indicating that the withdrawal was unsuccessful along with the current balance and overdraft limit.

```java
    public Object[] makeAutoWithdrawal(double amount) {
        //The amount value is already validated in the main method, that's why I don't need to add further validation logic here.
        try {
            if (amount <= 0) {throw new IllegalArgumentException("Invalid withdrawal amount.");}

            if (amount > getTotalBalance()) {throw new IllegalArgumentException("Withdrawal amount exceeds total balance limit.");}

            // First calculates the total amount for the withdrawal, including the overdraft fee,
            // Only than continues
            double withdrawFromBalance = Math.min(amount, getBalance());
            double balanceDifference = amount - withdrawFromBalance; // remaining amount to take from overdraft
            double overdraftFee = getOverdraftFee(balanceDifference); // Required overdraft fee
            double totalOverdraftAmount = balanceDifference + overdraftFee; // Total amount to be taken from overdraft, including fees

            // Guarantees that the overdraft fee is covered by the overdraft limit, otherwise the withdrawal cannot be processed.
            if(totalOverdraftAmount > getOverdraftLimit()){throw new IllegalArgumentException("Withdrawal amount exceeds total balance limit and fees.");}

            setBalance(-withdrawFromBalance);
            if (totalOverdraftAmount > 0) {
                setOverdraftLimit(-totalOverdraftAmount);
                return new Object[]{true, getBalance(), getOverdraftLimit(), true}; // Indicates that the overdraft was used
            }

            return new Object[]{true, getBalance(), getOverdraftLimit(), false}; // Indicates that the overdraft was not used

        } catch (IllegalArgumentException e) {
            System.err.println("Something went wrong while processing the withdrawal: " + e.getMessage());
            return new Object[]{false, getBalance(), getOverdraftLimit()};
        }
    }
```

#### makePayment(double amount, String paymentIdString) method

This method allows the user to make a payment by automatically determining whether to use the balance, the overdraft, or a combination of both based on the payment amount. It takes the payment amount and a payment ID as parameters, checks if the payment amount exceeds the total balance, and if so, it calculates how much of the payment can be covered by the balance and how much needs to be covered by the overdraft. It also calculates any applicable overdraft fees and checks if the total payment amount exceeds the combined limits. If the payment is successful, it updates both the balance and the overdraft limit accordingly, adds the payment details to the payment history, and returns an array of objects indicating whether the payment was successful along with the updated total balance. If there is an error during the process, it catches the exception and returns an array indicating that the payment was unsuccessful along with the current balance and overdraft limit.

```java
    public Object[] makePayment(double amount, String paymentIdString) {
        //The amount value is already validated in the main method, that's why I don't need to add further validation logic here.
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Invalid payment amount.");
            }

            if (amount > getTotalBalance()) {
                throw new IllegalArgumentException("Payment amount exceeds total balance limit.");
            }

            Object[] paymentResult = makeAutoWithdrawal(amount);

            if((Boolean) paymentResult[0]){
                System.out.println("Payment of R$" + amount + " with ID " + paymentIdString + " was successful.");
                addPaymentHistory(paymentIdString, amount);
                return new Object[]{true, getTotalBalance()};
            } else {
                throw new IllegalArgumentException("Payment failed due to insufficient funds.");

            }

        } catch (IllegalArgumentException e) {
            System.err.println("Something went wrong while processing the payment: " + e.getMessage());
            return new Object[]{false, getBalance(), getOverdraftLimit()};
        }
    }
```
