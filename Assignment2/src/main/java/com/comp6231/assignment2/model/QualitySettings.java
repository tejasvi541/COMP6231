package com.comp6231.assignment2.model;

/**
 * Class representing quality settings.
 * @author Tejasvi
 * @author Daivik
 * @author Pruthviraj
 */
public class QualitySettings {

    /**
     * Minimum bitrate for quality settings.
     */
    private int minBitrate;

    /**
     * Maximum bitrate for quality settings.
     */
    private int maxBitrate;

    /**
     * Constructor for QualitySettings.
     * @param minBitrate minimum bitrate to set.
     * @param maxBitrate maximum bitrate to set.
     */
    public QualitySettings(int minBitrate, int maxBitrate) {
        this.minBitrate = minBitrate;
        this.maxBitrate = maxBitrate;
    }

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

    /**
     * Overridden toString method.
     * @return String representation of the QualitySettings object.
     */
    public String toString(){
        return "MaxBirate : " + getMaxBitrate() + " & " + "MinBitrate : " + getMinBitrate() ;
    }
}
