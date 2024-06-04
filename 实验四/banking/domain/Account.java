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

    public void withdraw(double amount)throws OverdraftException{
        if(amount <= this.balance){
            this.balance -= amount;
        }else{
            double deficit = amount - this.balance;
            throw new OverdraftException("Insufficient funds",deficit);
        }
    }



}