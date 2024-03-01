package carlos.holanda.desafiobackendolisaude.repository;

import carlos.holanda.desafiobackendolisaude.model.Customer;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Override
    default List<Customer> findAll() {
        List<Customer> orderedCustomers = findAll(Sort.by("name").ascending());
        return orderedCustomers;
    }
}
