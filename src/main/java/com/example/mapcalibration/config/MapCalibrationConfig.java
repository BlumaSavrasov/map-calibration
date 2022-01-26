package com.example.mapcalibration.config;

import com.example.mapcalibration.model.QualityEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

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
    private final List<Integer> roads = Stream.iterate(1, i -> ++i).limit(100).collect(Collectors.toList());
    private Random r = ThreadLocalRandom.current();

    @Bean
    @Lazy
    //@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
    public List<QualityEvent> qualityEvents() {
        System.out.println("prod quality event was born");
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
}
