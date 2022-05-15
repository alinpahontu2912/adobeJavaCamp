package mystageservice.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mystageservice.domain.Performer;
import mystageservice.dto.PerformerOutputDto;
import mystageservice.services.PerformerService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PerformerController {

    private final PerformerService performerService;
    private final ModelMapper modelMapper;

    @GetMapping("/performers")
    public List<PerformerOutputDto> getPerformers() {
        List<Performer> performerList = performerService.findAll();
        return performerList.stream()
                .map(performer -> modelMapper.map(performer, PerformerOutputDto.class))
                .collect(Collectors.toList());
    }
}
