package banking.DAO;

import banking.domain.Customer;

import java.io.*;
import java.lang.reflect.Array;
import java.rmi.AlreadyBoundException;
import java.util.ArrayList;

public class CustomerDAO {
    private String fileName = "customers.dat";

    public void saveCustomers(ArrayList<Customer> customers){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
            oos.writeObject(customers);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Customer> loadCustomers(){
        ArrayList<Customer> customers = new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
            customers = (ArrayList<Customer>) ois.readObject();
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();;
        }
        return customers;
    }
}
