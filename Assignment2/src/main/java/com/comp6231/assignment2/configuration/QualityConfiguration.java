package com.comp6231.assignment2.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for quality settings.
 * The properties are prefixed with 'quality' in the application configuration or git config file.
 *@author Tejasvi
 *@author Daivik
 *@author Pruthviraj
 */
@Configuration
@ConfigurationProperties(prefix = "quality")
public class QualityConfiguration {

    /**
     * Minimum bitrate for quality configuration.
     */
    private int minBitrate;

    /**
     * Maximum bitrate for quality configuration.
     */
    private int maxBitrate;

    /**
     * Getter for minimum bitrate.
     * @return int minimum bitrate.
     */
    public int getMinBitrate() {
        return minBitrate;
    }

    /**
     * Setter for minimum bitrate.
     * @param minBitrate minimum bitrate to set.
     */
    public void setMinBitrate(int minBitrate) {
        this.minBitrate = minBitrate;
    }

    /**
     * Getter for maximum bitrate.
     * @return int maximum bitrate.
     */
    public int getMaxBitrate() {
        return maxBitrate;
    }

    /**
     * Setter for maximum bitrate.
     * @param maxBitrate maximum bitrate to set.
     */
    public void setMaxBitrate(int maxBitrate) {
        this.maxBitrate = maxBitrate;
    }
}
