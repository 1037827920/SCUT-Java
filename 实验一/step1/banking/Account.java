package banking;

public class Account {
    private double balancce;

    public Account(double balancce){
        this.balancce = balancce;
    }

    public double getBalance(){
        return this.balancce;
    }

    public void deposit(double amount){
        this.balancce += amount;
    }

    public void withdraw(double amount){
        this.balancce -= amount;
    }

    

}   