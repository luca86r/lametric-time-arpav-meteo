package com.lucarubin.services;

import it.redturtle.mobile.apparpav.types.Municipality;

import java.util.List;

public interface ZoneService {

    List<String> getProvincies();

    List<Municipality> getComuniByProvincia(String provincia);

    List<Integer> getAllZoneIds();
}
