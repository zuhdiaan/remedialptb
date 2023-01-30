package com.example.project.aplikasigempa.model;

import com.example.project.aplikasigempa.response.Geometry;
import com.example.project.aplikasigempa.response.Properties;

public class FeatureModel {
    private String type;
    private Properties properties;
    private Geometry geometry;
    private String id;

    public FeatureModel(String type, Properties properties, Geometry geometry, String id) {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
