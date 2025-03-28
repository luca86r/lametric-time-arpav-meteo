package com.lucarubin.services;

import com.lucarubin.models.SingleZoneForecast;
import it.redturtle.mobile.apparpav.utils.XMLParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

/**
 * Test class for ForecastServiceImpl.
 * It tests the behavior of the getAllForecasts method which retrieves all forecasts for zones using the ZoneService
 * and converts the data into a list of SingleZoneForecast objects.
 */
public class ForecastServiceImplTest {

    private static final int TAB = 9;
    private static final int NL = 10;
    private static final int CR = 13;

    @Before
    public void setUp()
        throws URISyntaxException, IOException {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (InputStream inputStream = new FileInputStream(new File(getClass().getClassLoader().getResource("sample_bollettino_app.xml").toURI()))) {
            int i = inputStream.read();
            while (i != -1) {
                if (i != TAB && i != NL && i != CR) {
                    byteArrayOutputStream.write(i);
                }
                i = inputStream.read();
            }
            XMLParser.getXML(null, byteArrayOutputStream.toString(StandardCharsets.UTF_8));
        }
    }

    @Test
    public void testGetAllForecasts_NoMeteogramData() {
        // Arrange
        ZoneService mockZoneService = Mockito.mock(ZoneService.class);
        ForecastServiceImpl forecastService = new ForecastServiceImpl(mockZoneService);

        Mockito.when(mockZoneService.getAllZoneIds()).thenReturn(List.of(1));

        // Act
        List<SingleZoneForecast> result = forecastService.getAllForecasts();

        // Assert
        Assert.assertNotNull(result);
        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void testGetAllForecasts_SingleZoneWithValidData() {
        // Arrange
        ZoneService mockZoneService = Mockito.mock(ZoneService.class);
        ForecastServiceImpl forecastService = new ForecastServiceImpl(mockZoneService);

        // Act
        List<SingleZoneForecast> result = forecastService.getAllForecasts();

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("Dolomiti Nord-Est", result.get(0).getZone().getName());
    }

    @Test
    public void testGetAllForecasts_MultipleZonesWithValidData() {
        // Arrange
        ZoneService mockZoneService = Mockito.mock(ZoneService.class);
        ForecastServiceImpl forecastService = new ForecastServiceImpl(mockZoneService);

        Mockito.when(mockZoneService.getAllZoneIds()).thenReturn(List.of(1, 2));

        // Act
        List<SingleZoneForecast> result = forecastService.getAllForecasts();

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(2, result.size());
        Assert.assertEquals("Dolomiti Nord-Est", result.get(0).getZone().getName());
        Assert.assertEquals("Dolomiti Sud-Ovest", result.get(1).getZone().getName());
    }

    @Test
    public void testGetAllForecasts_NullSlotInMeteogram() {
        // Arrange
        ZoneService mockZoneService = Mockito.mock(ZoneService.class);
        ForecastServiceImpl forecastService = new ForecastServiceImpl(mockZoneService);

        Mockito.when(mockZoneService.getAllZoneIds()).thenReturn(List.of(1));

        // Act
        List<SingleZoneForecast> result = forecastService.getAllForecasts();

        // Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("Dolomiti Nord-Est", result.get(0).getZone().getName());
        Assert.assertTrue(result.get(0).getForecasts().isEmpty());
    }

    @Test
    public void testGetAllForecasts_EmptyMeteogramList() {
        // Arrange
        ZoneService mockZoneService = Mockito.mock(ZoneService.class);
        ForecastServiceImpl forecastService = new ForecastServiceImpl(mockZoneService);

        Mockito.when(mockZoneService.getAllZoneIds()).thenReturn(Collections.emptyList());

        // Act
        List<SingleZoneForecast> result = forecastService.getAllForecasts();

        // Assert
        Assert.assertNotNull(result);
        Assert.assertTrue(result.isEmpty());
    }
}