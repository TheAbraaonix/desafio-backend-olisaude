package carlos.holanda.desafiobackendolisaude.service;

import carlos.holanda.desafiobackendolisaude.dto.CustomerRequest;
import carlos.holanda.desafiobackendolisaude.exception.RecordNotFoundException;
import carlos.holanda.desafiobackendolisaude.mapper.CustomerMapper;
import carlos.holanda.desafiobackendolisaude.model.Customer;
import carlos.holanda.desafiobackendolisaude.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public List<Customer> listAll() {
        return customerRepository.findAll();
    }

    public Customer listById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Customer create(CustomerRequest customer) {
        Customer newCustomer = customerMapper.toEntity(customer);
        return customerRepository.save(newCustomer);
    }

    public Customer update(Long id, CustomerRequest customer) {
        return customerRepository.findById(id)
                .map(recordFound -> {
                    Customer foundCustomer = customerMapper.toEntity(customer);
                    recordFound.setName(foundCustomer.getName());
                    recordFound.setBirthDate(foundCustomer.getBirthDate());
                    recordFound.setGender(foundCustomer.getGender());

                    return customerRepository.save(recordFound);
                }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public List<Customer> delete(Long id) {
        Customer deleteCustomer = customerRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
        customerRepository.delete(deleteCustomer);
        return listAll();
    }
}
