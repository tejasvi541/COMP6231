package com.comp6231.assignment2.model;

public class QualitySettings {
    private int minBitrate;
    private int maxBitrate;

    public QualitySettings(int minBitrate, int maxBitrate) {
        this.minBitrate = minBitrate;
        this.maxBitrate = maxBitrate;
    }

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

    public String toString(){
      return "MaxBirate : " + getMaxBitrate() + " & " + "MinBitrate : " + getMinBitrate() ;
    }
}
