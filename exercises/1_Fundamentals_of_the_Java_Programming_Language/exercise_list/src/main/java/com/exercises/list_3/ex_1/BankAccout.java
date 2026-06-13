package main.java.com.exercises.list_3.ex_1;
public class BankAccout {

    private double balance = 0.0;
    private double overdraftLimit = 0.0;
    private boolean firstDepositMade = true;
    private String accountHolderName;
    private short accountAge;
    
    BankAccout(String name, short age) {
        this.accountHolderName = name;
        this.accountAge = age;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public short getAccountAge() {
        return accountAge;
    }

    public void setAccountAge(short accountAge) {
        this.accountAge = accountAge;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance += balance;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    private void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    public double getTotalBalance(){
        return this.balance + this.overdraftLimit;
    }

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

    public Object[] makeOverdraftWithdrawal(double amount) {
        //The amount value is already validated in the main method, that's why I don't need to add further validation logic here. 
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Invalid withdrawal amount.");
            }

            if (amount > getOverdraftLimit()) {
                throw new IllegalArgumentException("Withdrawal amount exceeds overdraft limit.");
            }

            setOverdraftLimit(-amount);
            return new Object[]{true, getOverdraftLimit()};

        } catch (IllegalArgumentException e) {
            System.err.println("Something went wrong while processing the withdrawal: " + e.getMessage());
            return new Object[]{false, getOverdraftLimit()};
        }
    }

    public Object[] makeCombinedWithdrawal(double balance, double overdraft) {
        //The amount value is already validated in the main method, that's why I don't need to add further validation logic here. 
        try {

            if (balance <= 0) {throw new IllegalArgumentException("Invalid balance amount.");}

            if (balance > getBalance()) {throw new IllegalArgumentException("Balance amount exceeds total balance limit.");}

            if (overdraft <= 0) {throw new IllegalArgumentException("Invalid overdraft amount.");}

            if (overdraft > getOverdraftLimit()) {throw new IllegalArgumentException("Overdraft amount exceeds overdraft limit.");}
  
            setBalance(-balance);
            setOverdraftLimit(-overdraft);

            return new Object[]{true, getBalance(), getOverdraftLimit()};

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Something went wrong while processing the withdrawal at makeCombinedWithdrawal method: " + e.getMessage());
        }
    }

    public Object[] makeAutoWithdrawal(double amount) {
        //The amount value is already validated in the main method, that's why I don't need to add further validation logic here. 
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Invalid withdrawal amount.");
            }

            if (amount > getTotalBalance()) {
                throw new IllegalArgumentException("Withdrawal amount exceeds total balance limit.");
            }

            double balanceDifference = amount - getBalance();
            setBalance(-Math.min(amount, getBalance()));
            setOverdraftLimit(-Math.max(0, balanceDifference));

            return new Object[]{true, getBalance(), getOverdraftLimit()};

        } catch (IllegalArgumentException e) {
            System.err.println("Something went wrong while processing the withdrawal: " + e.getMessage());
            return new Object[]{false, getBalance(), getOverdraftLimit()};
        }
    }





    /**
     * Checks if the first deposit has been made and updates the flag accordingly. Is also responsible for validating the amount for the
     * overdraft limit. 
     * The overdraft amount is defined at the time of account creation, according to the amount deposited into the account at its creation;
     * If the amount deposited at account creation is R$500.00 or less, the overdraft should be R$50.00;
     * For amounts above R$500.00, the overdraft should be 50% of the deposited amount;
     * @param amount
     * @return true if the first deposit is made and the overdraft limit is set, false otherwise.
     */
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
    



}
