package com.lucarubin.models;

import it.redturtle.mobile.apparpav.types.Zone;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Represents a weather forecast for a specific geographical zone.
 * This class provides functionality to associate forecasts, represented
 * as instances of TimedForecast, with a Zone. It maintains forecasts in
 * a key-value structure where the key is the forecast title (day and time, see "slot" title in sample_bollettino_app.xml).
 */
public class SingleZoneForecast {

    private Zone zone;
    private Map<String, TimedForecast> forecast;

    public SingleZoneForecast(Zone zone) {

        this.zone = zone;
        forecast = new LinkedHashMap<>();
    }

    public Zone getZone() {

        return zone;
    }

    public void addForecast(TimedForecast timedForecast) {

        forecast.put(timedForecast.getTitle(), timedForecast);
    }

    public TimedForecast getForecastByTitle(String title) {

        return forecast.get(title);
    }

    public Map<String, TimedForecast> getForecasts() {

        return forecast;
    }
}
