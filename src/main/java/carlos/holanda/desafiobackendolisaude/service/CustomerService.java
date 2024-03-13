package carlos.holanda.desafiobackendolisaude.service;

import carlos.holanda.desafiobackendolisaude.dto.CustomerRequest;
import carlos.holanda.desafiobackendolisaude.dto.HealthProblemDTO;
import carlos.holanda.desafiobackendolisaude.exception.RecordNotFoundException;
import carlos.holanda.desafiobackendolisaude.mapper.CustomerMapper;
import carlos.holanda.desafiobackendolisaude.model.Customer;
import carlos.holanda.desafiobackendolisaude.model.HealthProblem;
import carlos.holanda.desafiobackendolisaude.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public Customer update(Long id, CustomerRequest customerRequest) {
        Customer existingCustomer = customerRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));

        existingCustomer.setName(customerRequest.name());
        existingCustomer.setBirthDate(customerRequest.birthDate());
        existingCustomer.setGender(customerRequest.gender());

        List<HealthProblem> newHealthProblems = new ArrayList<>();

        if (customerRequest.healthProblems() != null) {
            for (HealthProblemDTO healthProblemDTO : customerRequest.healthProblems()) {
                HealthProblem healthProblem = new HealthProblem();
                healthProblem.setId(healthProblemDTO.id());
                healthProblem.setName(healthProblemDTO.name());
                healthProblem.setDegree(healthProblemDTO.degree());
                healthProblem.setCustomer(existingCustomer);
                newHealthProblems.add(healthProblem);
            }
        }

        existingCustomer.getHealthProblems().clear();
        existingCustomer.getHealthProblems().addAll(newHealthProblems);

        return customerRepository.save(existingCustomer);
    }

    public List<Customer> delete(Long id) {
        Customer deleteCustomer = customerRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
        customerRepository.delete(deleteCustomer);
        return listAll();
    }
}
