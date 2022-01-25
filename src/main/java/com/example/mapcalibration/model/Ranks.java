package com.example.mapcalibration.model;

import com.example.mapcalibration.constant.EventType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;


@Data
@AllArgsConstructor
public class Ranks {
    private LocalDate localDate;
    private EventType eventType;
    private List<Double> limits;
}
