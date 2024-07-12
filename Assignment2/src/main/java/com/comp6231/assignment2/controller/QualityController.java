package com.comp6231.assignment2.controller;

import com.comp6231.assignment2.model.QualitySettings;
import com.comp6231.assignment2.configuration.QualityConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QualityController {

    @Autowired
    private QualityConfiguration qualityConfiguration;

    @GetMapping("/quality-settings")
    public QualitySettings getQualitySettings() {

        return new QualitySettings(qualityConfiguration.getMinBitrate(), qualityConfiguration.getMaxBitrate());
    }
    @GetMapping("/health")
    public String getHello() {
        return "Ok Report 👌";
    }
}
