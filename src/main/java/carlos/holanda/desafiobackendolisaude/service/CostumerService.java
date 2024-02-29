package carlos.holanda.desafiobackendolisaude.service;

import carlos.holanda.desafiobackendolisaude.model.Costumer;
import carlos.holanda.desafiobackendolisaude.repository.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CostumerService {
    @Autowired
    private CostumerRepository costumerRepository;

    public List<Costumer> findAll() {
        return costumerRepository.findAll();
    }

    public Optional<Costumer> findOne(Long id) {
        return costumerRepository.findById(id);
    }
}
