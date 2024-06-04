package banking;

import java.util.ArrayList;
import banking.Account;

public class Customer{
    private String firstName;
    private String lastName;
    private ArrayList<Account> accounts;

    public Customer(String firsName,String lastName){
        this.firstName  = firsName;
        this.lastName = lastName;
        this.accounts = new ArrayList<Account>();
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void addAccount(Account account){
        accounts.add(account);
    }

    public Account getAccount(int index){
        if(index >= 0 && index < accounts.size()){
            return accounts.get(index);
        }else{
            return null;
        }
    }

    public int getNumOfAccounts(){
        return accounts.size();
    }
}