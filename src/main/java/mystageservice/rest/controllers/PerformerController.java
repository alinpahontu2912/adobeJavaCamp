package mystageservice.rest.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mystageservice.ServiceDatabase;
import mystageservice.domain.Performer;
import mystageservice.rest.dto.PerformerOutputDto;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PerformerController {

    private final ServiceDatabase serviceDatabase;
    private final ModelMapper modelMapper;

    @GetMapping("performers")
    public List<PerformerOutputDto> getPerformers() {
        List<Performer> performerList = serviceDatabase.listPerformers();
        List<PerformerOutputDto> performerOutputDtoList = performerList.stream()
                .map(performer -> modelMapper.map(performer, PerformerOutputDto.class))
                .collect(Collectors.toList());
        return performerOutputDtoList;
    }
}
