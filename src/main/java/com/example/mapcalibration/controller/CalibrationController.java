package com.example.mapcalibration.controller;

import com.example.mapcalibration.model.RankedRoad;
import com.example.mapcalibration.services.CalibrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("calibration/")
public class CalibrationController {

    private final CalibrationService calibrationService;

    @GetMapping("/getRank")
    List<RankedRoad> getRank(@RequestParam int roadId) {
        return calibrationService.calibrate(roadId);
    }

}
