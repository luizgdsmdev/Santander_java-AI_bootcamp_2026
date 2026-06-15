package main.java.com.exercises.list_3.ex_1;
import java.util.ArrayList;
import java.util.List;

// I know the class name is misspelled, but I prefer to keep it this way to avoid having to change all the references to the class in the main method and in the ex_9 class, 
// since it's already implemented with the misspelled name and changing it would require changing all the references to it, which could lead to more errors if I miss any reference.

// TODO
// If the overdraft facility is used, the account must charge a fee of 20% of the overdraft amount used as soon as possible.
// Add overdraft use alert
// Update the documentation and also add to the list the extras funtionalities added outside the requirements

import main.java.com.exercises.list_3.GeneralMethods;
public class ex_9 extends GeneralMethods{
    private List<BankAccout> accounts = new ArrayList<>();

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

    private BankAccout selectBankAccount(){
        // Deals straight with the private List<BankAccout> accounts, so I don't need to worry about validating the list's content, 
        // since it's only possible to add valid BankAccout objects to the list through the createBankAccount method.
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
            System.err.println("\nInvalid account selection at selectBankAccount method.");
            return null;
        }

        //Correct's the index to match the list's index, since the user sees the options starting from 1, but the list starts from 0.
        int index = (int) accountIndex[1] - 1;
        if(index < 0 || index >= accounts.size()){
            System.out.println("\nInvalid account selection.");
            System.err.println("\nInvalid index account selection at selectBankAccount method.");
            return null;
        }

        return accounts.get(index);
    }

    private void useBankAccount(BankAccout account){
        
        System.out.println("What would you like to do? Current account: " + account.getAccountHolderName() + " \n0. return to the main menu \n1. Make a deposit \n2. Check balance \n3. Withdraw money \n4. Payment \n5. Payment history");
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
                System.out.println("Your overdraft limit is: R$" + account.getOverdraftLimit());
                System.out.println("Your total balance is: R$" + account.getTotalBalance() + "\n");
                useBankAccount(account);
            }
            case "3" -> {
                withdrawMoney(account);
                useBankAccount(account);
            }
            case "4" -> {
                makePayment(account);
                useBankAccount(account);
            }
            case "5" -> {
                System.out.println("\nPayment history:");
                List<Object[]> history = account.getPaymentHistory();
                if (history == null || history.isEmpty()) {
                    System.out.println("No payments made yet.\n");
                } else {
                    for (Object[] payment : history) {
                        System.out.println(" - Amount: R$" + payment[1] + " | Payment ID: " + payment[0]);
                    }
                }
                System.out.println();// Just to add a line break after the payment history.
                useBankAccount(account);
            }
            default -> {
                System.out.println("\nInvalid option. Please select one of the available options.");
                useBankAccount(account);
            }
        }
    }

    private void makePayment(BankAccout account){
        System.out.println("\nPlease provide the following information to make a payment:");
        System.out.print("Payment amount: ");
        String paymentAmount = getUserInput();
        isExit(paymentAmount);

        Object[] amountValidation = inputTypeValidation(paymentAmount, "double");
        if (!(boolean) amountValidation[0]) {
            System.out.println("\nInvalid payment amount. Please enter a valid number.");
            return;
        }

        System.out.print("Payment ID, if any: ");
        String paymentId = getUserInput();
        isExit(paymentId);

        Object[] paymentResult = account.makePayment((double) amountValidation[1], paymentId);

        if ((boolean) paymentResult[0]) {
            System.out.println("\nPayment made successfully. Your balance is now: R$" + account.getBalance() + "\n");
        } else{
            System.out.println("Something went wrong while processing the payment.\n");
        }
    }

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

    private void withdrawMoney(BankAccout account){
        try{
            withdrawalOptions(account);

        }catch(Exception e){
            System.err.println("Something went wrong while processing the withdrawal: " + e.getMessage());
            return;
        }
    }

    private boolean autoWithdrawal(BankAccout account){
        System.out.println("Set the desire amount to withdraw using your balance and overdraft. Your total is: R$" + account.getTotalBalance() + "\n");
        String withdrawalAmount = getUserInput();
        isExit(withdrawalAmount);

        Object[] amountValidation = inputTypeValidation(withdrawalAmount, "double");
        if (!(boolean) amountValidation[0]) {
            System.out.println("\nInvalid withdrawal amount. Please enter a valid number.");
            return false;
        }

        Object[] withdrawalResult = account.makeAutoWithdrawal((double) amountValidation[1]);
        if ((boolean) withdrawalResult[0]) {
            System.out.println("Withdrawal made successfully. Your balance is now: R$" + withdrawalResult[1] + " and your overdraft is now: R$" + withdrawalResult[2]);
            return true;
        } else{
            System.err.println("Something went wrong while processing the withdrawal. Please check the amount you want to withdraw.");
            return false;
        }
    }

    private boolean balanceOnlyWithdrawal(BankAccout account){
        System.out.println("Set the desire amount to withdraw using only your balance. Your total is: R$" + account.getBalance() + "\n");
        String withdrawalAmount = getUserInput();
        isExit(withdrawalAmount);

        Object[] amountValidation = inputTypeValidation(withdrawalAmount, "double");
        if (!(boolean) amountValidation[0]) {
            System.out.println("\nInvalid withdrawal amount. Please enter a valid number.");
            return false;
        }

        Object[] withdrawalResult = account.makeWithdrawal((double) amountValidation[1]);
        if ((boolean) withdrawalResult[0]) {
            System.out.println("Withdrawal made successfully. Your balance is now: R$" + withdrawalResult[1]);
            return true;
        } else{
            System.err.println("Something went wrong while processing the withdrawal. Please check the amount you want to withdraw.");
            return false;
        }
    }

    private boolean overdraftOnlyWithdrawal(BankAccout account){
        System.out.println("Set the desire amount to withdraw using only your overdraft. Your total is: R$" + account.getOverdraftLimit() + "\n");
        String withdrawalAmount = getUserInput();
        isExit(withdrawalAmount);

        Object[] amountValidation = inputTypeValidation(withdrawalAmount, "double");
        if (!(boolean) amountValidation[0]) {
            System.out.println("\nInvalid withdrawal amount. Please enter a valid number.");
            return false;
        }

        Object[] withdrawalResult = account.makeOverdraftWithdrawal((double) amountValidation[1]);
        if ((boolean) withdrawalResult[0]) {
            System.out.println("Withdrawal made successfully. Your balance is now: R$" + withdrawalResult[1]);
            return true;
        } else{
            System.err.println("Something went wrong while processing the withdrawal. Please check the amount you want to withdraw.");
            return false;
        }
    }

    private boolean combinedBalanceAndOverdraftWithdrawal(BankAccout account){
        System.out.println("\nYour total is: R$" + account.getTotalBalance() + "\n");
        System.out.println("Set the desire amount using your balance: R$" + account.getBalance() + "\n");
        String balanceAmount = getUserInput();
        isExit(balanceAmount);

        Object[] balanceAmountValidation = inputTypeValidation(balanceAmount, "double");
        if (!(boolean) balanceAmountValidation[0]) {
            System.err.println("\nInvalid withdrawal amount. Please enter a valid number.");
            return false;
        }

        System.out.println("Set the desire amount using your overdraft: R$" + account.getOverdraftLimit() + "\n");
        String overdraftAmount = getUserInput();
        isExit(overdraftAmount);

        Object[] overdraftValidation = inputTypeValidation(overdraftAmount, "double");
        if (!(boolean) overdraftValidation[0]) {
            System.err.println("\nInvalid withdrawal amount. Please enter a valid number.");
            return false;
        }

        Object[] withdrawalResult = account.makeCombinedWithdrawal((double) balanceAmountValidation[1], (double) overdraftValidation[1]);
        if ((boolean) withdrawalResult[0]) {
            System.out.println("Withdrawal made successfully. Remainning value: \n- Balance: R$" + withdrawalResult[1] + "\n- Overdraft: R$" + withdrawalResult[2]);
            return true;
        } else{
            System.err.println("Something went wrong while processing the withdrawal. Please check the amounts you want to withdraw.");
            return false;
        }
    }

    private void  withdrawalOptions(BankAccout account){
        boolean isValidOption = false;

        do{
            System.out.println("\nYour current balance is: R$" + account.getBalance() + " and your overdraft limit is: R$" + account.getOverdraftLimit() +  "\n1. Auto withdrawal \n2. Balance only \n3. Overdraft only \n4. Combine balance and overdraft \n5. Cancel the withdrawal\n");
            String userInput = getUserInput();
            isExit(userInput);

            // 1. Auto withdrawal 2. Balance only 3. Overdraft only 4. Combine balance and overdraft 5. Cancel the withdrawal
            switch (userInput.toLowerCase()) {
                case "1" -> {
                    isValidOption = autoWithdrawal(account);
                }
                case "2" -> {
                    isValidOption = balanceOnlyWithdrawal(account);
                }
                case "3" -> {
                    isValidOption = overdraftOnlyWithdrawal(account);
                }
                case "4" -> {
                    isValidOption = combinedBalanceAndOverdraftWithdrawal(account);
                }
                case "5", "cancel" -> {
                    System.out.println("\nWithdrawal cancelled. Returning to the previous menu.");
                    useBankAccount(account);
                    isValidOption = true;
                }
                default -> {
                    System.err.println("\nInvalid option. Please check the options and try again.");
                    withdrawalOptions(account);
                }
            }
        }while(!isValidOption);

    }

    public void ex_9_BankAccount(){
        System.out.println("\n\nWelcome to the Bank Account Program! \nIf you wish to leave, just type 'exit' or 'quit' at any time.");
        boolean isValid = false;

        try{
            do{
                System.out.println("Check the options below: \n0. back to the main menu \n1. Create a new bank account \n2. Use an existing bank account");
                String userInput = getUserInput();
                isExit(userInput);

                switch (userInput) {
                    case "0" -> {
                        isValid = true;
                    }
                    case "1" -> {
                        BankAccout newAccount = createBankAccount();
                        useBankAccount(newAccount);
                    }
                    case "2" -> {
                        BankAccout selectedAccount = selectBankAccount();
                        if (selectedAccount != null) {
                            useBankAccount(selectedAccount);
                        } else{
                            System.err.println("\nSomething went wrong while selecting a account, try again.");
                            throw new Exception("Account selection error at ex_9_BankAccount method.");
                        }
                    }
                    default -> System.out.println("\nInvalid option. Please select one of the available options.");
                }
            }while (!isValid);

            }catch(Exception e){
                System.err.println("Something went wrong while using the Bank Account Program: " + e.getMessage());
            }

    }
}
