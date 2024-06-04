package banking.domain;

public class Account {
    protected double balance;

    public Account(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return this.balance;
    }

    public boolean deposit(double amount){
        this.balance += amount;
        return true;
    }

    public boolean withdraw(double amount){
        if(amount <= this.balance){
            this.balance -= amount;
            return true;
        }else{
            return false;
        }
    }



}