package com.example.mapcalibration.config;

import com.example.mapcalibration.constant.Profiles;
import com.example.mapcalibration.model.QualityEvent;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;


import java.time.LocalDate;
import java.util.List;

@Profile(Profiles.TEST)
@Configuration
@ComponentScan(basePackages ="com.example.mapcalibration" ,lazyInit = true)
public class MapCalibrationTestConfig {

    @Bean
    List<QualityEvent> testQualityEvents() {
        LocalDate date = LocalDate.now();
        QualityEvent qualityEvent1 = QualityEvent.builder()
                .localDate(date)
                .roadId(1)
                .eventRate(50 / 100.0)
                .eventRate(25 / 100.0)
                .eventRate(50 / 100.0)
                .eventRate(75 / 100.0).build();
        QualityEvent qualityEvent2 = QualityEvent.builder()
                .localDate(date)
                .roadId(2)
                .eventRate(15 / 100.0)
                .eventRate(10 / 100.0)
                .eventRate(85 / 100.0)
                .eventRate(90 / 100.0).build();
        QualityEvent qualityEvent3 = QualityEvent.builder()
                .localDate(date)
                .roadId(3)
                .eventRate(3 / 100.0)
                .eventRate(65 / 100.0)
                .eventRate(97 / 100.0)
                .eventRate(65 / 100.0).build();
        QualityEvent qualityEvent4 = QualityEvent.builder()
                .localDate(date)
                .roadId(4)
                .eventRate(90 / 100.0)
                .eventRate(7 / 100.0)
                .eventRate(10 / 100.0)
                .eventRate(93 / 100.0).build();
        QualityEvent qualityEvent5 = QualityEvent.builder()
                .localDate(date)
                .roadId(5)
                .eventRate(55 / 100.0)
                .eventRate(27 / 100.0)
                .eventRate(52 / 100.0)
                .eventRate(77 / 100.0).build();
        QualityEvent qualityEvent6 = QualityEvent.builder()
                .localDate(date)
                .roadId(6)
                .eventRate(17 / 100.0)
                .eventRate(12 / 100.0)
                .eventRate(87 / 100.0)
                .eventRate(89 / 100.0).build();
        QualityEvent qualityEvent7 = QualityEvent.builder()
                .localDate(date)
                .roadId(7)
                .eventRate(34/ 100.0)
                .eventRate(61 / 100.0)
                .eventRate(94 / 100.0)
                .eventRate(60 / 100.0).build();
        QualityEvent qualityEvent8 = QualityEvent.builder()
                .localDate(date)
                .roadId(8)
                .eventRate(93 / 100.0)
                .eventRate(70 / 100.0)
                .eventRate(12 / 100.0)
                .eventRate(94 / 100.0).build();
        QualityEvent qualityEvent9 = QualityEvent.builder()
                .localDate(date)
                .roadId(9)
                .eventRate(31 / 100.0)
                .eventRate(60 / 100.0)
                .eventRate(90 / 100.0)
                .eventRate(45 / 100.0).build();
        QualityEvent qualityEvent10 = QualityEvent.builder()
                .localDate(date)
                .roadId(10)
                .eventRate(89 / 100.0)
                .eventRate(7 / 100.0)
                .eventRate(15 / 100.0)
                .eventRate(56 / 100.0).build();
        return List.of(qualityEvent1, qualityEvent2, qualityEvent3, qualityEvent4,qualityEvent5, qualityEvent6, qualityEvent7, qualityEvent8,qualityEvent9, qualityEvent10);
    }
}
