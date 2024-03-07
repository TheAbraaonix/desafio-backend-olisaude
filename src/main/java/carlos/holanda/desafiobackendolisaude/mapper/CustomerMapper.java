package carlos.holanda.desafiobackendolisaude.mapper;

import carlos.holanda.desafiobackendolisaude.dto.CustomerRequest;
import carlos.holanda.desafiobackendolisaude.dto.CustomerResponse;
import carlos.holanda.desafiobackendolisaude.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public CustomerResponse toDTO(Customer customer) {
        if (customer == null) {
            return null;
        }

        return new CustomerResponse(customer.getId(), customer.getName(), customer.getBirthDate(), customer.getGender(), customer.getCreatedAt(), customer.getUpdatedAt());
    }

    public Customer toEntity(CustomerRequest customerRequest) {
        if (customerRequest == null) {
            return null;
        }

        Customer customer = new Customer();
        customer.setName(customerRequest.name());
        customer.setBirthDate(customerRequest.birthDate());
        customer.setGender(customerRequest.gender());
        return customer;
    }
}
