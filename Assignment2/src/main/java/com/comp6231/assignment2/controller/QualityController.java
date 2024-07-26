package com.comp6231.assignment2.controller;

import com.comp6231.assignment2.model.QualitySettings;
import com.comp6231.assignment2.configuration.QualityConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A Rest Controller for managing quality settings.
 * @author Tejasvi
 * @author Daivik
 * @author Pruthviraj
 */
@RestController
public class QualityController {

    /**
     * Autowired QualityConfiguration object.
     */
    @Autowired
    private QualityConfiguration qualityConfiguration;

    /**
     * Get mapping for '/quality-settings' endpoint.
     * @return QualitySettings object with min and max bitrate from qualityConfiguration.
     */
    @GetMapping("/quality-settings")
    public QualitySettings getQualitySettings() {
        return new QualitySettings(qualityConfiguration.getMinBitrate(), qualityConfiguration.getMaxBitrate());
    }

    /**
     * Get mapping for '/health' endpoint.
     * @return String "Ok Report 👌".
     */
    @GetMapping("/health")
    public String getHello() {
        return "Ok Report 👌";
    }
}
