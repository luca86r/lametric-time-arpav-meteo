package com.lucarubin.services;

import com.lucarubin.models.SingleZoneForecast;

import java.util.List;

public interface ForecastService {

    public List<SingleZoneForecast> getAllForecasts();
}
