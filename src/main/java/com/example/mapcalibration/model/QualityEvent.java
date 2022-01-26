package com.example.mapcalibration.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class QualityEvent {
    @Id
    private String id;
    private LocalDate localDate;
    private int roadId;
    @Singular
    private List<Double> eventRates;
}
