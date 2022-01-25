package com.example.mapcalibration.services;

import com.example.mapcalibration.constant.EventType;
import com.example.mapcalibration.dao.QualityEventRepo;
import com.example.mapcalibration.model.QualityEvent;
import com.example.mapcalibration.model.RankedRoad;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CalibrationServiceImpl implements CalibrationService {



    private final QualityEventRepo qualityEventRepo;
    private final RanksManager ranksManager;

    @Override
    public List<RankedRoad> calibrate(int roadId) {
        return qualityEventRepo.findAll(roadId).stream().map(this::rankRoad).collect(Collectors.toList());
    }

    private RankedRoad rankRoad(QualityEvent qualityEvent) {
        LocalDate localDate = qualityEvent.getLocalDate();

        int[] ranks = Arrays.stream(EventType.values())
                .mapToInt(eventType -> calculateRank(localDate, eventType, qualityEvent.getEventRates().get(eventType.getEventNumberIndex())))
                .toArray();

        return new RankedRoad(localDate, qualityEvent.getRoadId(), ranks);
    }


    int calculateRank(LocalDate localDate, EventType eventType, double eventRate) {
        List<Double> limits = ranksManager.getLimits(localDate, eventType.getEventNumberIndex());
        int rank = 0;
        for (int i = 0; i < limits.size(); i++) {
            Double limit = limits.get(i);
            if (limit > eventRate) {
                rank = i + 1;
                break;
            }
        }
        if (rank == 0) {
            rank = limits.size() + 1;
        }
        if(!eventType.isPositive()){
            rank=limits.size()+2-rank;
        }
        return rank;
    }
}
