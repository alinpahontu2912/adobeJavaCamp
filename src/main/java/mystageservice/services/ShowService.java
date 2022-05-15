package mystageservice.services;

import mystageservice.domain.Show;
import mystageservice.repository.ShowRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {

    private final ShowRepository showRepository;

    public ShowService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    public List<Show> listAllShows() {
        return showRepository.findAll();
    }
}
