package banking;

public class Customer{
    private String firstName;
    private String lastName;
    private Account account;

    public Customer(String firsName,String lastName){
        this.firstName  = firsName;
        this.lastName = lastName;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public Account getAccount(){
        return this.account;
    }

    public void setAccount(Account account){
        this.account = account;
    }
}