package mystageservice.rest.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mystageservice.ServiceDatabase;
import mystageservice.domain.Show;
import mystageservice.rest.dto.ShowOutputDto;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ShowController {

    private final ServiceDatabase serviceDatabase;
    private final ModelMapper modelMapper;

    @GetMapping("shows")
    public List<ShowOutputDto> displayShows() {
        List<Show> allShows = serviceDatabase.listShows();
        List<ShowOutputDto> showsDto = allShows.stream().map(
                        show -> modelMapper.map(show, ShowOutputDto.class))
                .collect(Collectors.toList());
        return showsDto;
    }

}
