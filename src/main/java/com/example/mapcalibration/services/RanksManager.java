package com.example.mapcalibration.services;


import com.example.mapcalibration.constant.EventType;
import com.example.mapcalibration.dao.QualityEventRepo;
import com.example.mapcalibration.model.QualityEvent;
import com.example.mapcalibration.model.Ranks;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Getter
public class RanksManager {

    private Integer[] percentiles;

    private Map<LocalDate, List<Ranks>> ranksMap = new HashMap<>();

    private final QualityEventRepo qualityEventRepo;

    public List<Double> getLimits(LocalDate localDate, int eventNumberIndex) {
        return ranksMap.get(localDate).get(eventNumberIndex).getLimits();
    }

    public RanksManager(@Value("${continual.percentiles}") Integer[] percentiles, QualityEventRepo qualityEventRepo) {
        this.percentiles = percentiles;
        this.qualityEventRepo = qualityEventRepo;
        calculateRanks();
    }

    private void calculateRanks() {
        Map<LocalDate, List<QualityEvent>> qualityEventsPerDay = qualityEventRepo.getLastWeekEvents();
        qualityEventsPerDay.forEach((localDate, qualityEvents) -> ranksMap.put(localDate, calculateRanks(localDate, qualityEvents)));
    }

    private List<Ranks> calculateRanks(LocalDate localDate, List<QualityEvent> qualityEvents) {
        EventType[] eventTypes = EventType.values();
        List<Ranks> ranks = new ArrayList<>();
        for (EventType eventType : eventTypes) {
            List<Double> scores = qualityEvents.stream()
                    .map(qualityEvent -> qualityEvent.getEventRates().get(eventType.getEventNumberIndex()))
                    .sorted()
                    .collect(Collectors.toList());
            List<Double> limits = getLimits(scores);
            ranks.add(new Ranks(localDate, eventType, limits));
        }
        return ranks;
    }


    private List<Double> getLimits(List<Double> scores) {
        List<Double> limits = new ArrayList<>();

        for (Integer percentile : percentiles) {
            limits.add(scores.get((int)(percentile * scores.size() / 100.0)));
        }

        return limits;
    }
}
