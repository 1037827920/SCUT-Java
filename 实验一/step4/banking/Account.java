package banking;

public class Account {
    private double balancce;

    public Account(double balancce){
        this.balancce = balancce;
    }

    public double getBalance(){
        return this.balancce;
    }

    public boolean deposit(double amount){
        this.balancce += amount;
        return true;
    }

    public boolean withdraw(double amount){
        if(amount <= this.balancce){
            this.balancce -= amount;
            return true;
        }else{
            return false;
        }
    }

    

}   