package com.example.mapcalibration.services;

import com.example.mapcalibration.constant.EventType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        int rank = calibrationService.calculateRank(null, EventType.EVENT_1, 0.1).getRank();
        assertEquals(4,rank);
        rank = calibrationService.calculateRank(null,EventType.EVENT_1,0.3).getRank();
        assertEquals(3,rank);
        rank = calibrationService.calculateRank(null,EventType.EVENT_1,0.5).getRank();
        assertEquals(2,rank);
        rank = calibrationService.calculateRank(null,EventType.EVENT_1,0.8).getRank();
        assertEquals(1,rank);
    }
    @Test
    void calculateTestEvent3Rank() {
        int rank = calibrationService.calculateRank(null, EventType.EVENT_3, 0.1).getRank();
        assertEquals(1,rank);
        rank = calibrationService.calculateRank(null,EventType.EVENT_3,0.3).getRank();
        assertEquals(2,rank);
        rank = calibrationService.calculateRank(null,EventType.EVENT_3,0.5).getRank();
        assertEquals(3,rank);
        rank = calibrationService.calculateRank(null,EventType.EVENT_3,0.8).getRank();
        assertEquals(4,rank);
    }
}