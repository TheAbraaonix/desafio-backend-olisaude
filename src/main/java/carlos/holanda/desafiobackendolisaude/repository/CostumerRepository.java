package carlos.holanda.desafiobackendolisaude.repository;

import carlos.holanda.desafiobackendolisaude.model.Costumer;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CostumerRepository extends JpaRepository<Costumer, Long> {
    @Override
    default List<Costumer> findAll() {
        List<Costumer> orderedCostumers = findAll(Sort.by("name").ascending());
        return orderedCostumers;
    }
}
