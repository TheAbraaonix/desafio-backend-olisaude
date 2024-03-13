package carlos.holanda.desafiobackendolisaude.service;

import carlos.holanda.desafiobackendolisaude.dto.CustomerScoreDTO;
import carlos.holanda.desafiobackendolisaude.model.Customer;
import carlos.holanda.desafiobackendolisaude.model.HealthProblem;
import carlos.holanda.desafiobackendolisaude.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class HealthRiskCalculator {
    private final CustomerRepository customerRepository;

    public HealthRiskCalculator(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerScoreDTO> topTenCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerScoreDTO> scores = customers
                .stream()
                .map(customer -> new CustomerScoreDTO(customer.getId(), customer.getName(), healthScore(customer)))
                .sorted((a, b) -> Double.compare(b.score(), a.score()))
                .toList();

        return scores.stream().limit(10).collect(Collectors.toList());
    }

    private double healthScore(Customer customer) {
        int sumDegree = customer.getHealthProblems()
                .stream()
                .mapToInt(HealthProblem::getDegree)
                .sum();

        double scoreFormula =  (1 / (1 + Math.pow(2.71828,-(-2.8 + sumDegree)))) * 100;
        return Math.round(scoreFormula * 100/ 100);
    }
}
