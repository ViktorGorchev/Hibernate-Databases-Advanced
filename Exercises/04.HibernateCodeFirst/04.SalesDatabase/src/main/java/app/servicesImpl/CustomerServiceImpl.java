package app.servicesImpl;

import app.dao.CustomerDao;
import app.domain.Customer;
import app.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public void persist(Customer customer) {
        this.customerDao.saveAndFlush(customer);
    }
}
