package mystageservice.services;

import mystageservice.domain.Performer;
import mystageservice.repository.PerformerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformerService {

    private final PerformerRepository performerRepository;

    public PerformerService(PerformerRepository performerRepository) {
        this.performerRepository = performerRepository;
    }

    public void addPerformer(Performer performer) {
        performerRepository.save(performer);
    }

    public List<Performer> findAll() {
        return performerRepository.findAll();
    }

    public Performer findById(String name) throws Exception {
        Performer performer = performerRepository.findFirstByName(name);
        if (performer == null) {
            throw new Exception("Performer not found");
        }
        return performer;
    }

}
