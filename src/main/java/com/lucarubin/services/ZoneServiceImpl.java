package com.lucarubin.services;

import it.redturtle.mobile.apparpav.types.Municipality;
import it.redturtle.mobile.apparpav.utils.Global;
import it.redturtle.mobile.apparpav.utils.PLISTParser;
import it.redturtle.mobile.apparpav.utils.Util;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ZoneServiceImpl implements ZoneService {

    private static final Logger LOGGER = Logger.getLogger(ZoneServiceImpl.class.getName());

    @Override
    public List<String> getProvincies() {

        LOGGER.info("Getting provinces...");

        if (Global.istance().getProvinces().isEmpty()) {
            loadData();
        }

        List<String> provinces = Global.istance().getProvinces().stream() //
                                       .map(p -> String.valueOf(p.get("title"))).toList();

        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.info("Provinces retrieved (%s)".formatted(provinces.size()));
        }

        return provinces;
    }

    @Override
    public List<Municipality> getComuniByProvincia(String provincia) {

        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.info("Getting municipalities for province '%s' ...".formatted(provincia));
        }

        if (Global.istance().getProvinces().isEmpty()) {
            loadData();
        }

        List<Municipality> comuni = Global.istance().getMunicipalities(provincia).stream() //
                                          .map(m -> (Municipality) m.get("municipality")).toList();

        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.info("Municipalities retrieved for province '%s' (%s)".formatted(provincia, comuni.size()));
        }

        return comuni;
    }

    private void loadData() {

        LOGGER.info("Loading data...");

        String plistComuni = Util.getPLIST(null);

        boolean loadResult = PLISTParser.getPlist(null, plistComuni);

        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.info("Loading completed with result: " + loadResult);
        }
    }

}
