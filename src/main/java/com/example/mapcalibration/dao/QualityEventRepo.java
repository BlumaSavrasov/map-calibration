package com.example.mapcalibration.dao;

import com.example.mapcalibration.model.QualityEvent;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public interface QualityEventRepo  {
    List<QualityEvent> findByRoadIdEquals(int roadId);

    List<QualityEvent> findByLocalDateGreaterThanEqual(LocalDate start);

    default Map<LocalDate, List<QualityEvent>> getLastWeekEvents(){
        return findByLocalDateGreaterThanEqual(LocalDate.now().minusWeeks(1))
                .stream().collect(groupingBy(QualityEvent::getLocalDate));
    }
}
