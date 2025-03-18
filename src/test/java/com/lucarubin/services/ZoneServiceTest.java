package com.lucarubin.services;

import it.redturtle.mobile.apparpav.types.Municipality;
import it.redturtle.mobile.apparpav.utils.Global;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ZoneServiceTest {

    public static final String PADOVA = "Padova";
    public static final int PADOVA_COMUNI_COUNT = 104;
    public static final String ABANO_TERME = "Abano Terme";
    private static final int PROVINCES_SIZE = 7;
    public static final String VICENZA = "Vicenza";

    private ZoneService zoneService;

    @Before
    public void setUp() {

        zoneService = new ZoneServiceImpl();
    }

    @Test
    public void testGetProvinciesEmptyReload() {

        Global.istance().getProvinces().clear();
        List<String> provinces = zoneService.getProvincies();
        assertEquals(PROVINCES_SIZE, provinces.size());
    }

    @Test
    public void testGetProvinciesWithData() {

        Global.istance().getProvinces().clear();

        List<String> provinces = zoneService.getProvincies();
        assertEquals(PROVINCES_SIZE, provinces.size());
        assertTrue(provinces.contains(VICENZA));
        assertTrue(provinces.contains(PADOVA));
    }

    @Test
    public void testGetComuniByProvinciaEmptyReload() {

        Global.istance().getProvinces().clear();

        List<Municipality> comuni = zoneService.getComuniByProvincia(PADOVA);
        assertEquals(PADOVA_COMUNI_COUNT, comuni.size());
    }

    @Test
    public void testGetComuniByProvinciaWithData() {

        Global.istance().getProvinces().clear();

        List<Municipality> comuni = zoneService.getComuniByProvincia(PADOVA);
        assertEquals(PADOVA_COMUNI_COUNT, comuni.size());
        assertTrue(comuni.stream().anyMatch(m -> m.getName().equals(ABANO_TERME)));
    }
}