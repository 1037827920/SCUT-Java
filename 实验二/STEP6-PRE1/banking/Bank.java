package banking;


public class Bank{
    private Customer customers[];
    private int numberOfCustomers;

    public Bank(){
        this.customers = new Customer[5];
        this.numberOfCustomers = 0;
    }
    public Bank(int size){
        this.customers = new Customer[size];
        this.numberOfCustomers = 0;
    }

    public void addCustomer(String firstName,String lastName){
        Customer newData = new Customer(firstName,lastName);
        customers[numberOfCustomers] = newData;
        numberOfCustomers++;
    }

    public int getNumOfCustomers(){
        return this.numberOfCustomers;
    }

    public Customer getCustomer(int index){
        return this.customers[index];
    }
}