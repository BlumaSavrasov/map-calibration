package com.example.mapcalibration.services;

import com.example.mapcalibration.constant.EventType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

class CalibrationServiceImplTest {

    static CalibrationServiceImpl  calibrationService;

    @BeforeAll
    static void beforeAll() {
        RanksManager ranksManagerMock = Mockito.mock(RanksManager.class);
        Mockito.when(ranksManagerMock.getLimits(any(),anyInt())).thenReturn(List.of(0.2,0.4,0.7));
        calibrationService = new CalibrationServiceImpl(null,ranksManagerMock);
    }

    @Test
    void calculateTestEvent1Rank() {
        int rank = calibrationService.calculateRank(null, EventType.EVENT_1, 0.1);
        assertEquals(4,rank);
        rank = calibrationService.calculateRank(null,EventType.EVENT_1,0.3);
        assertEquals(3,rank);
        rank = calibrationService.calculateRank(null,EventType.EVENT_1,0.5);
        assertEquals(2,rank);
        rank = calibrationService.calculateRank(null,EventType.EVENT_1,0.8);
        assertEquals(1,rank);
    }
}