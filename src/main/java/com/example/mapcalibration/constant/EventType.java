package com.example.mapcalibration.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum EventType {
    EVENT_1(0,false),
    EVENT_2(1,false),
    EVENT_3(2,true),
    EVENT_4(3,true);
    @Getter
    private final int eventNumberIndex;
    @Getter
    private final boolean positive;

}
