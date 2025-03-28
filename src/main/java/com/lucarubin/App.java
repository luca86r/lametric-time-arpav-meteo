package com.lucarubin;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.lucarubin.models.SingleZoneForecast;
import com.lucarubin.services.ForecastService;
import com.lucarubin.services.ForecastServiceImpl;
import com.lucarubin.services.ZoneService;
import com.lucarubin.services.ZoneServiceImpl;
import it.redturtle.mobile.apparpav.types.Meteogram;
import it.redturtle.mobile.apparpav.types.Municipality;
import it.redturtle.mobile.apparpav.utils.Global;
import it.redturtle.mobile.apparpav.utils.Util;
import it.redturtle.mobile.apparpav.utils.XMLParser;

import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        testConvertJson();

        ZoneService zoneService = new ZoneServiceImpl();
        List<Municipality> comuniPadova = zoneService.getComuniByProvincia("Padova");

        System.out.println(comuniPadova.stream().findFirst().map(Municipality::getZoneid).orElse("nd"));

        XMLParser.getXML(null, Util.getXML(null));
        Meteogram meteograms = Global.istance().getMeteogramsByZoneIDS(comuniPadova.stream().findFirst().map(Municipality::getZoneid).orElse("nd"));

        ForecastService forecastService = new ForecastServiceImpl(new ZoneServiceImpl());
        List<SingleZoneForecast> allForecasts = forecastService.getAllForecasts();

        // Converti la lista allForecasts in JSON e stampala
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Converte la lista allForecasts in una stringa JSON formattata
            String allForecastsJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(allForecasts);
            System.out.println(allForecastsJson);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void testConvertJson() {

        String xml = Util.getXML(null);

        try {
            // Creare un ObjectMapper XML
            XmlMapper xmlMapper = new XmlMapper();

            // Convertire l'XML in un JsonNode
            JsonNode jsonNode = xmlMapper.readTree(xml);

            // Creare un ObjectMapper JSON
            ObjectMapper objectMapper = new ObjectMapper();

            // Convertire il JsonNode in una stringa JSON formattata
            String jsonString = objectMapper.writeValueAsString(jsonNode);

            // Stampare la stringa JSON
            System.out.println(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
