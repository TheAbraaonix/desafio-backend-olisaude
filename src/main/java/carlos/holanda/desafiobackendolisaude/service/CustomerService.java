package carlos.holanda.desafiobackendolisaude.service;

import carlos.holanda.desafiobackendolisaude.model.Customer;
import carlos.holanda.desafiobackendolisaude.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Optional<Customer> findOne(Long id) {
        Optional<Customer> foundCustomer = customerRepository.findById(id);
        if(foundCustomer.isEmpty()) {
            throw new RuntimeException("Customer does not exist.");
        }
        return foundCustomer;
    }

    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> delete(Long id) {
        Optional<Customer> deleteCustomer = customerRepository.findById(id);
        if(deleteCustomer.isEmpty()) {
            throw new RuntimeException("Customer does not exist.;");
        }
        return findAll();
    }
}
