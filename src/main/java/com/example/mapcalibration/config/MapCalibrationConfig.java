package com.example.mapcalibration.config;

import com.example.mapcalibration.model.QualityEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class MapCalibrationConfig {
    private final int numOfCallEvent = 100;
    private final int numOfDataEvent = 100;
    private final List<Integer> roads = Stream.iterate(1,i->++i).limit(100).collect(Collectors.toList());
    private Random r = ThreadLocalRandom.current();

    @Bean
    List<QualityEvent> qualityEvents() {
        List<LocalDate> dates = Stream.iterate(LocalDate.now(), localDate -> localDate.minusDays(1)).limit(7).collect(Collectors.toList());
        return dates.stream()
                .flatMap(this::getEventListPerDay)
                .collect(Collectors.toList());
    }

    private Stream<QualityEvent> getEventListPerDay(LocalDate localDate) {
        return roads.stream().map(roadId -> {
            double randomValueCall = r.nextInt(numOfCallEvent);
            double randomValueData = r.nextInt(numOfDataEvent);
            return QualityEvent.builder()
                    .eventRate(randomValueCall / numOfCallEvent)
                    .eventRate(randomValueData / numOfDataEvent)
                    .eventRate(1 - randomValueCall / numOfCallEvent)
                    .eventRate(1 - randomValueData / numOfDataEvent)
                    .localDate(localDate)
                    .roadId(roadId)
                    .build();
        });
    }

//    @Bean
//    Map<LocalDate, List<QualityEvent>> qualityEventsGroupedByDate() {
//        return qualityEvents().stream().collect(groupingBy(QualityEvent::getLocalDate));
//    }
//
//    @Bean
//    Map<Integer, List<QualityEvent>> qualityEventsGroupedByRoad() {
//        return qualityEvents().stream().collect(groupingBy(QualityEvent::getRoadId));
//    }

//    @Bean
//    List<QualityEvent> qualityEvents() {
//        LocalDate date = LocalDate.now();
//        QualityEvent qualityEvent1 = QualityEvent.builder()
//                .localDate(date)
//                .roadId(1)
//                .eventRate(50 / 100.0)
//                .eventRate(25 / 100.0)
//                .eventRate(50 / 100.0)
//                .eventRate(75 / 100.0).build();
//        QualityEvent qualityEvent2 = QualityEvent.builder()
//                .localDate(date)
//                .roadId(2)
//                .eventRate(15/100.0)
//                .eventRate(10/100.0)
//                .eventRate(85/100.0)
//                .eventRate(90/100.0).build();
//        QualityEvent qualityEvent3 = QualityEvent.builder()
//                .localDate(date)
//                .roadId(3)
//                .eventRate(3/100.0)
//                .eventRate(65/100.0)
//                .eventRate(97/100.0)
//                .eventRate(65/100.0).build();
//        QualityEvent qualityEvent4 = QualityEvent.builder()
//                .localDate(date)
//                .roadId(4)
//                .eventRate(90/100.0)
//                .eventRate(7/100.0)
//                .eventRate(10/100.0)
//                .eventRate(93/100.0).build();
//        return List.of(qualityEvent1, qualityEvent2, qualityEvent3, qualityEvent4);
//    }


//    @Bean
//    Map<LocalDate, List<QualityEvent>> qualityEvents( List<QualityEvent> qualityEvent) {
//        List<LocalDate> dates = List.of(LocalDate.now());
//        HashMap<LocalDate, List<QualityEvent>> map = new HashMap<>();
//        dates.forEach(localDate -> map.put(localDate, qualityEvent));
//        return map;
//    }
}
