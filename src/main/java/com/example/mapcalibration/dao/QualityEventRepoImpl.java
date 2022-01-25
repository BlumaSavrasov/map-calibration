package com.example.mapcalibration.dao;

import com.example.mapcalibration.constant.Profiles;
import com.example.mapcalibration.model.QualityEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.example.mapcalibration.constant.Profiles.NO_MONGO;
import static java.util.stream.Collectors.groupingBy;

@Repository
@Profile(NO_MONGO)
public class QualityEventRepoImpl implements QualityEventRepo {
    @Autowired
    private List<QualityEvent> qualityEvents;

    @Override
    public List<QualityEvent> findAll(int roadId) {
        return qualityEvents.stream().collect(groupingBy(QualityEvent::getRoadId)).get(roadId);
    }

    @Override
    public Map<LocalDate,List<QualityEvent>> findAll() {
        return qualityEvents.stream().collect(groupingBy(QualityEvent::getLocalDate));
    }

    @Override
    public List<QualityEvent> findByLocalDateBetween(LocalDate start, LocalDate end) {
        return qualityEvents.stream()
                .filter(qualityEvent -> qualityEvent.getLocalDate().isAfter(start))
                .filter(qualityEvent ->qualityEvent.getLocalDate().isBefore(end)||qualityEvent.getLocalDate().isEqual(end))
                .collect(Collectors.toList());
    }
}
