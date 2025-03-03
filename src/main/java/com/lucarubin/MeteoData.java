package com.lucarubin;

import it.redturtle.mobile.apparpav.Radar;

import java.util.List;
import java.util.Map;

public class MeteoData {

    private final Map<String, Object> bulletins;
    private final Map<String, Object> meteograms;
    private final List<Radar> radars;

    public MeteoData(Map<String, Object> bulletins, Map<String, Object> meteograms, List<Radar> radars ) {

        this.bulletins = bulletins;
        this.meteograms = meteograms;
        this.radars = radars;
    }

    public Map<String, Object> getBulletins() {

        return bulletins;
    }

    public Map<String, Object> getMeteograms() {

        return meteograms;
    }

    public List<Radar> getRadars() {

        return radars;
    }
}
