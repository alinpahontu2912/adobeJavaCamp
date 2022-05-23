package mystageservice.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mystageservice.MyStageUtil;
import mystageservice.domain.Performer;
import mystageservice.dto.PerformerOutputDto;
import mystageservice.services.PerformerService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
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
        Collections.sort(performerList, MyStageUtil.performerNameComparator);
        return performerList.stream()
                .map(performer -> modelMapper.map(performer, PerformerOutputDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/performers/rating")
    public List<PerformerOutputDto> getPerformersRating() {
        List<Performer> performerList = performerService.findAll();
        Collections.sort(performerList, MyStageUtil.performerRatingComparator);
        List<PerformerOutputDto> list = new ArrayList<>();
        for (Performer performer : performerList) {
            PerformerOutputDto map = modelMapper.map(performer, PerformerOutputDto.class);
            list.add(map);
        }
        return list;
    }

    @GetMapping("performers/{name}")
    public Performer getPerformer(@PathVariable String name) throws Exception {
        Performer wantedPerformer = performerService.findById(name);
        if (wantedPerformer == null) throw new Exception("No such Performer");
        return wantedPerformer;
    }

}
