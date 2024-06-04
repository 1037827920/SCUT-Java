package banking.UI;

import banking.domain.*;
import banking.domain.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainWindow extends JFrame {
    private Bank bank;
    private DefaultListModel<String> customerListModel;

    private JTextField firstNameField;
    private JTextField lastNameField;
    private JButton addButton;
    private JButton deleteButton;
    private JTextField searchField;
    private JButton searchButton;
    private JButton sortButton;
    private JList<String> customerList;

    public MainWindow() {
        this.bank = Bank.getBank();
        this.customerListModel = new DefaultListModel<>();
        this.bank.loadCustomers();
        updateCustomerList(bank.getCustomers());

        // Initialize UI components
        firstNameField = new JTextField(20);
        lastNameField = new JTextField(20);
        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        searchField = new JTextField(20);
        searchButton = new JButton("Search");
        sortButton = new JButton("Sort");
        customerList = new JList<>(customerListModel);

        // Add action listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                if (!firstName.isEmpty() && !lastName.isEmpty()) {
                    bank.addCustomer(firstName, lastName);
                    updateCustomerList(bank.getCustomers());
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = customerList.getSelectedIndex();
                if (selectedIndex >= 0) {
                    bank.deleteCustomer(selectedIndex);
                    updateCustomerList(bank.getCustomers());
                }
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchTerm = searchField.getText();
                if (!searchTerm.isEmpty()) {
                    ArrayList<Customer> searchResults = searchCustoemrs(searchTerm);
                    updateCustomerList(searchResults);
                }else{
                    updateCustomerList(bank.getCustomers());
                }
            }

            public ArrayList<Customer> searchCustoemrs(String term){
                ArrayList<Customer> results = new ArrayList<>();
                for(int i = 0; i < bank.getNumOfCustomers();i++){
                    if(bank.getCustomer(i).getFullName().toLowerCase().contains(term.toLowerCase())){
                        results.add(bank.getCustomer(i));
                    }
                }
                return results;
            }
        });

        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bank.sortCustomers();
                updateCustomerList(bank.getCustomers());
            }
        });

        // Set layout and add components to the frame
        setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(new JLabel("First Name:"));
        inputPanel.add(firstNameField);
        inputPanel.add(new JLabel("Last Name:"));
        inputPanel.add(lastNameField);
        inputPanel.add(addButton);
        inputPanel.add(deleteButton);

        JPanel searchPanel = new JPanel(new FlowLayout());
        searchPanel.add(new JLabel("Search:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        searchPanel.add(sortButton);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(customerList), BorderLayout.CENTER);
        add(searchPanel, BorderLayout.SOUTH);

        // Load customers from file
        bank.loadCustomers();
        updateCustomerList(bank.getCustomers());
    }

    private void updateCustomerList(ArrayList<Customer> customers) {
        customerListModel.clear();
        for (int i = 0; i < customers.size(); i++) {
            customerListModel.addElement(customers.get(i).getLastName() + ", " +customers.get(i).getFirstName());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainWindow mainWindow = new MainWindow();
            mainWindow.setTitle("Bank Customer Management System");
            mainWindow.setSize(800, 600);
            mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainWindow.setVisible(true);
        });
    }
}
