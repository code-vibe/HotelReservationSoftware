package service;

import model.Customer;

import java.util.Collection;
import java.util.Objects;
import java.util.HashMap;
import java.util.Map;

public class CustomerService {

    //Declaring a static property that will reference the class

    public static CustomerService customerService;
    public static final Map<String, Customer> customers = new HashMap<>();

    public CustomerService() {}

    //Create new Customer Service

    public static CustomerService getInstance(){

        //If customerService == null => create new customerService
        if(Objects.isNull(customerService)){
            customerService = new CustomerService();
        }
        return customerService;
    }

    public void addCustomer( String firstName, String lastName, String email){
        Customer newCustomer = new Customer(firstName, lastName, email);
        customers.put(newCustomer.getEmail(), newCustomer);

    }

    public static Customer getCustomer(String email){
        if(!customers.containsKey(email))
            return null;
        else
            return customers.get(email);
    }


    //Display all customer data

    public Collection<Customer> getAllCustomers() {
        return customers.values();
    }

}
