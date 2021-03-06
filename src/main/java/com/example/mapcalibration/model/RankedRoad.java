package com.example.mapcalibration.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class RankedRoad {
    private LocalDate localDate;
    private int roadId;
    private List<RankedEvent> eventRanks;
}
