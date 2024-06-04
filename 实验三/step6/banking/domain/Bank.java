package banking.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.random.RandomGenerator;

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

    public Customer searchCustomers(String lastName, String firstName){
        for(Customer customer: customers){
            if(customer.getLastName().equalsIgnoreCase(lastName) && customer.getFirstName().equalsIgnoreCase(firstName)){
                return customer;
            }
        }
        return null;
    }

    public void sortCustomers(){
        Collections.sort(customers);
    }
}