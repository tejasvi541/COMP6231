package com.comp6231.assignment2.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "quality")
public class QualityConfiguration {
    private int minBitrate;
    private int maxBitrate;

    public int getMinBitrate() {
        return minBitrate;
    }

    public void setMinBitrate(int minBitrate) {
        this.minBitrate = minBitrate;
    }

    public int getMaxBitrate() {
        return maxBitrate;
    }

    public void setMaxBitrate(int maxBitrate) {
        this.maxBitrate = maxBitrate;
    }
}
