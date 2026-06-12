package main.java.com.exercises.list_3.ex_1;
import java.util.ArrayList;
import java.util.List;

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
}
