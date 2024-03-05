package carlos.holanda.desafiobackendolisaude.service;

import carlos.holanda.desafiobackendolisaude.dto.CustomerRequest;
import carlos.holanda.desafiobackendolisaude.exception.RecordNotFoundException;
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

    public List<Customer> listAll() {
        return customerRepository.findAll();
    }

    public Customer listById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Customer create(CustomerRequest customer) {
        Customer newCustomer = new Customer(customer);
        return customerRepository.save(newCustomer);
    }

    public List<Customer> delete(Long id) {
        Customer deleteCustomer = customerRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
        customerRepository.delete(deleteCustomer);
        return listAll();
    }
}
