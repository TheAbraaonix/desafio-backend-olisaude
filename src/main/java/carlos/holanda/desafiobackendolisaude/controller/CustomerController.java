package carlos.holanda.desafiobackendolisaude.controller;

import carlos.holanda.desafiobackendolisaude.dto.CustomerRequest;
import carlos.holanda.desafiobackendolisaude.dto.CustomerResponse;
import carlos.holanda.desafiobackendolisaude.mapper.CustomerMapper;
import carlos.holanda.desafiobackendolisaude.model.Customer;
import carlos.holanda.desafiobackendolisaude.service.CustomerService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    public CustomerController(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> listAll() {
        List<CustomerResponse> customerResponseList = customerService.listAll()
                .stream()
                .map(customerMapper::toDTO)
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(customerResponseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> listById(@PathVariable @NotNull @Positive Long id) {
        CustomerResponse customerResponse = customerMapper.toDTO(customerService.listById(id));
        return ResponseEntity.status(HttpStatus.FOUND).body(customerResponse);
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> create(@RequestBody @Valid @NotNull CustomerRequest customer) {
        Customer savedCustomer = customerService.create(customer);
        CustomerResponse customerResponse = customerMapper.toDTO(savedCustomer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> update(@PathVariable @NotNull @Positive Long id,
                                                   @RequestBody @Valid CustomerRequest customer) {
        Customer updatedCustomer = customerService.update(id, customer);
        CustomerResponse customerResponse = customerMapper.toDTO(updatedCustomer);
        return ResponseEntity.status(HttpStatus.OK).body(customerResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<CustomerResponse>> delete(@PathVariable @NotNull @Positive  Long id) {
        List<CustomerResponse> customerResponseList = customerService.delete(id)
                .stream()
                .map(customerMapper::toDTO)
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(customerResponseList);
    }
}
