package app.services;

import app.domain.Customer;

public interface CustomerService {
    void persist(Customer customer);
}
