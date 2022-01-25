package com.example.mapcalibration.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class RankedRoad {
    private LocalDate localDate;
    private int roadId;
    private int[] eventRanks;
}
