package com.example.mapcalibration.services;

import com.example.mapcalibration.model.RankedRoad;

import java.util.List;

public interface CalibrationService {
    List<RankedRoad> calibrate(int roadId);
}
