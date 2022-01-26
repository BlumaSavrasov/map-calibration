package com.example.mapcalibration.model;

import com.example.mapcalibration.constant.EventType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RankedEvent {
    private EventType eventType;
    private int rank;
}
