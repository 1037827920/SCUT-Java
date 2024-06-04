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

    public boolean withdraw(double amount){
        if(super.getBalance() >= amount){
            super.withdraw(amount);
            return true;
        }else{
            if(overdraftProtection >= (amount - super.getBalance())){
                super.withdraw(this.balance);
                overdraftProtection -=  (amount - super.getBalance());
                return true;
            }else{
                return false;
            }
        }
    }

    public double getOverdraftProtection(){
        return this.overdraftProtection;
    }
    
}