package com.example.mapcalibration.services;

import com.example.mapcalibration.constant.Profiles;
import com.example.mapcalibration.dao.QualityEventRepo;
import com.example.mapcalibration.model.RankedRoad;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.PostConstruct;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles(Profiles.NO_MONGO)
class CalibrationServiceIntegrationTest {
    @Autowired
    CalibrationService calibrationService;
    @Test
    void calibrate() {
        int[] eventRanks = calibrationService.calibrate(3).get(0).getEventRanks();

        assertArrayEquals(new int[]{4,1,4,1},eventRanks);

    }
}