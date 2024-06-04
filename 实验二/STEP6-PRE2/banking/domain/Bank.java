package banking.domain;

import java.util.ArrayList;
import banking.domain.*;

public class Bank{
    private static Bank bankInstance;
    private ArrayList<Customer> customers;
    private int numberOfCustomers;

    private Bank(){
        this.customers = new ArrayList<>();
        this.numberOfCustomers = 0;
    }

    public static Bank getBank(){
        if(bankInstance == null){
            bankInstance = new Bank();
        }
        return bankInstance;
    }

    public void addCustomer(String firstName,String lastName){
        customers.add(new Customer(firstName,lastName));
        numberOfCustomers++;
    }

    public int getNumOfCustomers(){
        return this.numberOfCustomers;
    }

    public Customer getCustomer(int index){
        return this.customers.get(index);
    }
}