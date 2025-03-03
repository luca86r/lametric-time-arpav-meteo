package com.lucarubin;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import it.redturtle.mobile.apparpav.utils.Util;
import it.redturtle.mobile.apparpav.utils.XMLParser;

import java.io.IOException;
import java.util.Optional;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        // input
        int zoneId = 11; // Vicenza

        String xml = Util.getXML(null);
        Optional<MeteoData> meteoData = XMLParser.getXML(xml);


        testConvertJson(xml);


    }

    private static void testConvertJson(String xml) {

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
