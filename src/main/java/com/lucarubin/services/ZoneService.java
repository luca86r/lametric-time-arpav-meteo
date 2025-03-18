package com.lucarubin.services;

import it.redturtle.mobile.apparpav.types.Municipality;

import java.util.List;

public interface ZoneService {

    public List<String> getProvincies();

    public List<Municipality> getComuniByProvincia(String provincia);

}
