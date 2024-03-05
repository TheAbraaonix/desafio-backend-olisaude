package carlos.holanda.desafiobackendolisaude.controller;

import carlos.holanda.desafiobackendolisaude.dto.CustomerRequest;
import carlos.holanda.desafiobackendolisaude.model.Customer;
import carlos.holanda.desafiobackendolisaude.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> listById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.FOUND).body(customerService.listById(id));
    }

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody CustomerRequest customer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.create(customer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Customer>> delete(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.delete(id));
    }
}
