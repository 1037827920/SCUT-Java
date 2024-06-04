package banking.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.random.RandomGenerator;

import banking.domain.*;
import banking.DAO.CustomerDAO;

public class Bank{
    private static Bank bankInstance;
    private ArrayList<Customer> customers;
    private int numberOfCustomers;
    private CustomerDAO customerDAO;

    private Bank(){
        this.customers = new ArrayList<>();
        this.numberOfCustomers = 0;
        this.customerDAO = new CustomerDAO();
    }

    public static Bank getBank(){
        if(bankInstance == null){
            bankInstance = new Bank();
        }
        return bankInstance;
    }

    public ArrayList<Customer> getCustomers(){
        return customers;
    }

    public void addCustomer(String firstName,String lastName){
        customers.add(new Customer(firstName,lastName));
        numberOfCustomers++;
        customerDAO.saveCustomers(customers);
    }

    public void deleteCustomer(int index) {
        if (index >= 0 && index < numberOfCustomers) {
            customers.remove(index);
            numberOfCustomers--;
            customerDAO.saveCustomers(customers);
        }
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

    public void loadCustomers(){
        customers = customerDAO.loadCustomers();
        numberOfCustomers = customers.size();
    }
}