package com.example.BIKE_RENTAL.controllers;

import com.example.BIKE_RENTAL.dao.entities.Customer;
import com.example.BIKE_RENTAL.dao.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CustomerController {
    final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("customer")
    Customer getCustomer(@RequestParam("customerId") int customerId){
        logger.info("customer id is {}",customerId);
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()){
            Customer temp = customer.get();
            return temp;
        }else{
            return null;
        }
    }

    /*@PostMapping("customer")
    public ResponseEntity<String> createCustomer(@RequestParam("customerId") int customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);

        if (customer.isPresent()) {
            return ResponseEntity.ok("Existing User");
        } else {
            return ResponseEntity.ok("New User");
        }
    }*/

    @PostMapping("customer")
    public ResponseEntity<String> createCustomerByEmail(
            @RequestBody Customer customer) {

        logger.info("customer object is {}", customer);

         Optional<Customer> customer1 = customerRepository.findByEmail(customer.getEmail());

        logger.info("is customer present: {}", customer1.isPresent());

        if (customer1.isPresent()) {
            if (customer1.get().getActiveUser() == 1){
                return ResponseEntity.ok("User already active");
            }else{
                Customer c = customer1.get();
                c.setActiveUser(1);
                customerRepository.save(c);
                return ResponseEntity.ok("User already exists and is activated now.");
            }
        } else {
            customer.setActiveUser(1);
            customerRepository.save(customer);
            return ResponseEntity.ok("New User Created");
        }
    }

    @PutMapping("customer/deregister")
    public ResponseEntity<String> deregisterCustomer(
            @RequestParam("email") String email) {

        logger.info("Deregister request via email: {}", email);

        Optional<Customer> existingCustomer = customerRepository.findByEmail(email);

        if (existingCustomer.isPresent()) {
            Customer foundCustomer = existingCustomer.get();
            foundCustomer.setActiveUser(0);
            customerRepository.save(foundCustomer);
            return ResponseEntity.ok("User account has been successfully de-activated");
        } else {
            return ResponseEntity.ok("No user exists with the provided email");
        }
    }


}


