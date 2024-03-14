package carlos.holanda.desafiobackendolisaude.service;

import carlos.holanda.desafiobackendolisaude.enums.Gender;
import carlos.holanda.desafiobackendolisaude.exception.RecordNotFoundException;
import carlos.holanda.desafiobackendolisaude.model.Customer;
import carlos.holanda.desafiobackendolisaude.model.HealthProblem;
import carlos.holanda.desafiobackendolisaude.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.empty;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class CustomerServiceTest {
    @InjectMocks
    CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;

    @Test
    @DisplayName("Should get one customer successfully.")
    void listCustomerByIdCase1() {
        //Arrange
        Long customerId = 1L;
        Long healthProblemId = 1L;
        LocalDateTime createdAt = LocalDateTime.now();
        List<HealthProblem> healthProblemMockList = new ArrayList<>();

        Customer mockCustomer = new Customer(customerId, "Name 1", LocalDate.of(2003,02,13), Gender.MALE, createdAt);
        healthProblemMockList.add(new HealthProblem(healthProblemId, "Health Problem 1", 1));
        mockCustomer.setHealthProblems(healthProblemMockList);

        Mockito.when(customerRepository.findById(customerId)).thenReturn(Optional.of(mockCustomer));

        //Action
        Customer retrievedCustomer = customerService.listById(customerId);

        //Assertions
        assertNotNull(retrievedCustomer);
        assertEquals("Name 1", retrievedCustomer.getName());
        assertEquals(LocalDate.of(2003,02,13), retrievedCustomer.getBirthDate());
        assertEquals(Gender.MALE, retrievedCustomer.getGender());
        assertEquals(1, retrievedCustomer.getHealthProblems().size());
        assertEquals("Health Problem 1", retrievedCustomer.getHealthProblems().get(0).getName());
        assertEquals(1, retrievedCustomer.getHealthProblems().get(0).getDegree());

        verify(customerRepository, times(1)).findById(customerId);
    }

    @Test
    @DisplayName("Should throw exception if customer does not exist.")
    void listCustomerByIdCase2() throws RecordNotFoundException {
        // Arrange
        Long customerId = 999L;
        Mockito.when(customerRepository.findById(customerId)).thenReturn(Optional.empty());

        // Action and Assertions
        assertThrows(RecordNotFoundException.class, () -> {
            customerService.listById(customerId);
        });
    }
}