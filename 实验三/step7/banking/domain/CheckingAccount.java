package banking.domain;

import banking.domain.Account;

/**
 * CheckingAccount
 */
public class CheckingAccount extends Account{
    private double overdraftProtection;

    public CheckingAccount(double balance){
        super(balance);
    }
    public CheckingAccount(double balance, double protect){
        super(balance);
        this.overdraftProtection = protect;
    }

    public void withdraw(double amount) throws OverdraftException{
        if(super.getBalance() >= amount){
            super.withdraw(amount);
        }else{
            double deficit = amount - super.getBalance();
            if(overdraftProtection >= deficit){
                super.withdraw(super.getBalance());
                overdraftProtection -=  deficit;
                throw new OverdraftException("Insufficient funds for overdraft protection",deficit);
            }else{
                throw new OverdraftException("No overdraft protection",deficit);
            }
        }
    }

    public double getOverdraftProtection(){
        return this.overdraftProtection;
    }

}