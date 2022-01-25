//package com.example.mapcalibration.config;
//
//import com.example.mapcalibration.model.QualityEvent;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//
//
//import java.time.LocalDate;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Profile("test")
//@Configuration
//public class MapCalibrationTestConfig {
//
//    @Bean
//    List<QualityEvent> qualityEvent() {
//        QualityEvent qualityEvent1 = new QualityEvent(1, 50.0 / 100, 25.0 / 100, 50.0 / 100, 75.0 / 100);
//        QualityEvent qualityEvent2 = new QualityEvent(2, 15.0 / 100, 10.0 / 100, 85.00 / 100, 90.0 / 100);
//        QualityEvent qualityEvent3 = new QualityEvent(3, 3.0 / 100, 65.0 / 100, 97.0 / 100, 65.0 / 100);
//        QualityEvent qualityEvent4 = new QualityEvent(4, 90.0 / 100, 7.0 / 100, 10.0 / 100, 93.0 / 100);
//        return List.of(qualityEvent1,qualityEvent2,qualityEvent3,qualityEvent4);
//    }
//
//    @Bean
//    Map<LocalDate, List<QualityEvent>> qualityEvents( List<QualityEvent> qualityEvent) {
//        List<LocalDate> dates = List.of(LocalDate.now());
//        HashMap<LocalDate, List<QualityEvent>> map = new HashMap<>();
//        dates.forEach(localDate -> map.put(localDate, qualityEvent));
//        return map;
//    }
//}
