package carlos.holanda.desafiobackendolisaude.mapper;

import carlos.holanda.desafiobackendolisaude.dto.CustomerRequest;
import carlos.holanda.desafiobackendolisaude.dto.CustomerResponse;
import carlos.holanda.desafiobackendolisaude.dto.HealthProblemDTO;
import carlos.holanda.desafiobackendolisaude.model.Customer;
import carlos.holanda.desafiobackendolisaude.model.HealthProblem;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {
    public CustomerResponse toDTO(Customer customer) {
        if (customer == null) {
            return null;
        }
        List<HealthProblemDTO> healthProblemsDTO = customer.getHealthProblems()
                .stream()
                .map(healthProblem -> new HealthProblemDTO(healthProblem.getName(), healthProblem.getDegree()))
                .toList();

        return new CustomerResponse(customer.getId(), customer.getName(), customer.getBirthDate(), customer.getGender(), healthProblemsDTO,
                customer.getCreatedAt(), customer.getUpdatedAt());
    }

    public Customer toEntity(CustomerRequest customerRequest) {
        if (customerRequest == null) {
            return null;
        }

        Customer customer = new Customer();
        customer.setName(customerRequest.name());
        customer.setBirthDate(customerRequest.birthDate());
        customer.setGender(customerRequest.gender());

        List<HealthProblem> healthProblems =  customerRequest.healthProblems()
                .stream()
                .map(healthProblemDTO -> {
                    var healthProblem = new HealthProblem();
                    healthProblem.setName(healthProblemDTO.name());
                    healthProblem.setDegree(healthProblemDTO.degree());
                    healthProblem.setCustomer(customer);
                    return healthProblem;
                })
                .collect(Collectors.toList());
        customer.setHealthProblems(healthProblems);

        return customer;
    }
}
