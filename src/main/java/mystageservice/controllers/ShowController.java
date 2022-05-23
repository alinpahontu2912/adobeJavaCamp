package mystageservice.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mystageservice.MyStageUtil;
import mystageservice.domain.Show;
import mystageservice.dto.ShowApiOutputDto;
import mystageservice.dto.ShowOutputDto;
import mystageservice.services.ShowService;
import mystageservice.services.movieApi.ShowApiService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ShowController {

    private final ModelMapper modelMapper;
    private final ShowService showService;

    @GetMapping("shows")
    public List<ShowOutputDto> displayShows() {
        List<Show> allShows = showService.listAllShows();
        return allShows.stream().map(
                        show -> modelMapper.map(show, ShowOutputDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("shows/sortby{type}")
    public List<ShowOutputDto> sortShows(@PathVariable String type) {
        List<Show> sorted = new ArrayList<>(showService.listAllShows());
        switch (type) {
            case "rating":
                sorted.sort(MyStageUtil.ratingComparator);
                break;
            case "popularity":
                sorted.sort(MyStageUtil.popularPerformersComparator);
                break;
        }
        return sorted.stream().map(
                show -> modelMapper.map(show, ShowOutputDto.class)).collect(Collectors.toList());
    }

    @GetMapping("shows/{title}")
    public ShowApiOutputDto getShow(@PathVariable String title) throws Exception {
        return ShowApiService.getInfo(title);
    }

    @GetMapping("shows/Api/{title}")
    public ShowApiOutputDto getInternetShow(@PathVariable String title) throws Exception {
        return ShowApiService.getInfo(title);
    }

}
