package com.example.mapcalibration.utills;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "continual")
@Getter
@Setter
@Component
public class PropertyContainer {
    private int[] percentiles;

    public int getNumberOfRanks(){
        return percentiles.length+1;
    }

    public int getNumberOfLimits(){
        return percentiles.length+2;
    }
}
