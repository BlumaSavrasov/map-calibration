package com.example.mapcalibration.dao;

import com.example.mapcalibration.model.QualityEvent;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public interface QualityEventRepo{
    List<QualityEvent> findAll(int roadId);
    Map<LocalDate,List<QualityEvent>> findAll();
    List<QualityEvent> findByLocalDateBetween(LocalDate start,LocalDate end);
    default Map<LocalDate, List<QualityEvent>> getLastWeekEvents(){
        return findByLocalDateBetween(LocalDate.now().minusWeeks(1),LocalDate.now())
                .stream().collect(groupingBy(QualityEvent::getLocalDate));
    }
}
