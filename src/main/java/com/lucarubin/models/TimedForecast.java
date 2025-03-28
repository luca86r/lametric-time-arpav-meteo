package com.lucarubin.models;

/**
 * Represents a weather forecast data point for a specific time period,
 * encapsulating various meteorological details and metadata.
 * <p>
 * Is equivalent to a single "slot" tag of sample_bollettino_app.xml
 * Note: slots with two values map to two instances of this class.
 */
public class TimedForecast {

    private String title;
    private Integer icon;
    private String temperature;
    private String temperature2000;
    private String temperature3000;
    private String precipitation;
    private String precipitationProbability;
    private String snow;
    private String reliability;

    public TimedForecast() {

    }

    public TimedForecast(String title, Integer icon, String temperature, String temperature2000, String temperature3000, String precipitation,
        String precipitationProbability, String snow, String reliability) {

        this.title = title;
        this.icon = icon;
        this.temperature = temperature;
        this.temperature2000 = temperature2000;
        this.temperature3000 = temperature3000;
        this.precipitation = precipitation;
        this.precipitationProbability = precipitationProbability;
        this.snow = snow;
        this.reliability = reliability;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public Integer getIcon() {

        return icon;
    }

    public void setIcon(Integer icon) {

        this.icon = icon;
    }

    public String getTemperature() {

        return temperature;
    }

    public void setTemperature(String temperature) {

        this.temperature = temperature;
    }

    public String getTemperature2000() {

        return temperature2000;
    }

    public void setTemperature2000(String temperature2000) {

        this.temperature2000 = temperature2000;
    }

    public String getTemperature3000() {

        return temperature3000;
    }

    public void setTemperature3000(String temperature3000) {

        this.temperature3000 = temperature3000;
    }

    public String getPrecipitation() {

        return precipitation;
    }

    public void setPrecipitation(String precipitation) {

        this.precipitation = precipitation;
    }

    public String getPrecipitationProbability() {

        return precipitationProbability;
    }

    public void setPrecipitationProbability(String precipitationProbability) {

        this.precipitationProbability = precipitationProbability;
    }

    public String getSnow() {

        return snow;
    }

    public void setSnow(String snow) {

        this.snow = snow;
    }

    public String getReliability() {

        return reliability;
    }

    public void setReliability(String reliability) {

        this.reliability = reliability;
    }
}
