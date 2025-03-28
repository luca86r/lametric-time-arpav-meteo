package com.lucarubin.services;

import com.lucarubin.ArpavToLaMetricTimeIconConverter;
import com.lucarubin.errors.MeteogramDataNotValidException;
import com.lucarubin.models.SingleZoneForecast;
import com.lucarubin.models.TimedForecast;
import it.redturtle.mobile.apparpav.types.Meteogram;
import it.redturtle.mobile.apparpav.types.Row;
import it.redturtle.mobile.apparpav.types.Slot;
import it.redturtle.mobile.apparpav.types.Zone;
import it.redturtle.mobile.apparpav.utils.Global;
import it.redturtle.mobile.apparpav.utils.Util;
import it.redturtle.mobile.apparpav.utils.XMLParser;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ForecastServiceImpl implements ForecastService {

    private static final Logger LOGGER = Logger.getLogger(ForecastServiceImpl.class.getName());
    public static final String ROW_MAP_KEY_TITLE = "title";
    public static final String ROW_MAP_KEY_TYPE = "type";
    public static final String ROW_MAP_KEY_VALUE = "value";
    public static final String ROW_MAP_KEY_VALUE1 = "value1";
    public static final String ROW_MAP_KEY_VALUE2 = "value2";
    public static final String ROW_MAP_VALUE_FOR_KEY_TYPE_TITLE = "title";
    public static final String ROW_MAP_VALUE_FOR_KEY_TYPE_IMAGE = "image";
    public static final String ROW_MAP_VALUE_FOR_KEY_TYPE_TEXT = "text";
    public static final String ROW_MAP_VALUE_FOR_KEY_TITLE_TEMPERATURA = "Temperatura";
    public static final String ROW_MAP_VALUE_FOR_KEY_TITLE_TEMPERATURA2000M = "Temperatura 2000m";
    public static final String ROW_MAP_VALUE_FOR_KEY_TITLE_TEMPERATURA3000M = "Temperatura 3000m";
    public static final String ROW_MAP_VALUE_FOR_KEY_TITLE_PRECIPITAZIONI = "Precipitazioni";
    public static final String ROW_MAP_VALUE_FOR_KEY_TITLE_PROBABILITA_PRECIPITAZIONI = "Probabilita' precipitazione";
    public static final String ROW_MAP_VALUE_FOR_KEY_TITLE_QUOTA_NEVE = "Quota neve";
    public static final String ROW_MAP_VALUE_FOR_KEY_TITLE_ATTENDIBILITA = "Attendibilita'";
    public static final int ROW_TYPE_SINGLE = 0;
    public static final int ROW_TYPE_DOUBLE = 1;
    public static final int ROW_CONTENT_TYPE_TITLE = 0;
    public static final int ROW_CONTENT_TYPE_IMAGE = 1;
    public static final int ROW_CONTENT_TYPE_TEXT = 2;

    private final ZoneService zoneService;

    public ForecastServiceImpl(ZoneService zoneService) {

        this.zoneService = zoneService;
    }

    @Override
    public List<SingleZoneForecast> getAllForecasts() {

        LOGGER.info("Getting all forecasts...");

        if (Global.istance().getMeteogramsByZoneIDS("1") == null) {
            loadData();
        }

        List<SingleZoneForecast> forecasts =
            zoneService.getAllZoneIds().stream().map(id -> convertMeteogramToSingleZoneForecast(Global.istance().getMeteogramsByZoneIDS(id.toString())))
                       .toList();

        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.info("All forecasts retrieved (%s)".formatted(forecasts.size()));
        }

        return forecasts;
    }

    private SingleZoneForecast convertMeteogramToSingleZoneForecast(Meteogram meteogram) {

        if (meteogram == null) {
            return null;
        }

        SingleZoneForecast forecast = new SingleZoneForecast(new Zone(meteogram.getZoneid(), meteogram.getName()));

        List<TimedForecast> timedForecasts = new LinkedList<>();
        meteogram.getListOfSlot().forEach(slot -> timedForecasts.addAll(convertSlotToTimedForecast(slot)));

        timedForecasts.forEach(forecast::addForecast);

        return forecast;
    }

    private List<TimedForecast> convertSlotToTimedForecast(Slot slot) {

        if (slot == null) {
            return List.of();
        }

        List<TimedForecast> timedForecasts = new ArrayList<>();

        try {

            if (isSlotContainingDoubleRows(slot)) {
                timedForecasts.addAll(convertSlotWithDoubleRowsToTimedForecast(slot));
            }
            else {
                timedForecasts.add(convertSlotWithSingleRowsToTimedForecast(slot));
            }
        }
        catch (MeteogramDataNotValidException e) {
            LOGGER.warning("Meteogram data not valid: " + e.getMessage());
        }
        return timedForecasts;
    }

    /**
     * Checks if a given Slot contain at least one double row (ex. morning + afternoon)
     *
     * @param slot the Slot instance to be checked
     * @return true if the Slot containt at least one double row, otherwise false
     */
    private boolean isSlotContainingDoubleRows(Slot slot) {

        return slot.getListOfRows().stream().anyMatch(row -> row.getMap().containsKey(ROW_MAP_KEY_TITLE) && isDoubleValueRow(row));
    }

    /**
     * Convert a Slot with only sigle value rows, in an instance of TimedForecast
     */
    private TimedForecast convertSlotWithSingleRowsToTimedForecast(Slot slot)
        throws MeteogramDataNotValidException {

        if (slot == null) {
            return null;
        }

        TimedForecast tf = new TimedForecast();

        // row.type: 0 (single), 1 (double)
        // row.contentType: 0 (row.map.type==title), 1 (row.map.type==image), 2 (row.map.type==text)
        // row.map.title:
        // row.map.type:
        // row.map.value:
        // row.map.value1:
        // row.map.value2:

        for (Row row : slot.getListOfRows()) {

            if (row.getContentType() == ROW_CONTENT_TYPE_TITLE) {
                extractDataFromRowTitle(row, tf, ROW_MAP_KEY_VALUE);
            }
            else if (row.getContentType() == ROW_CONTENT_TYPE_IMAGE) {
                extractDataFromRowImage(row, tf, ROW_MAP_KEY_VALUE);
            }
            else if (row.getContentType() == ROW_CONTENT_TYPE_TEXT) {
                extractDataFromRowText(row, tf, ROW_MAP_KEY_VALUE);
            }
            else {
                LOGGER.warning("Unknown row content type: " + row.getContentType());
                throw new MeteogramDataNotValidException();
            }
        }

        return tf;
    }

    /**
     * Convert a Slot with at least a double value row, in an instance of TimedForecast
     */
    private List<TimedForecast> convertSlotWithDoubleRowsToTimedForecast(Slot slot)
        throws MeteogramDataNotValidException {

        if (slot == null) {
            return List.of();
        }

        TimedForecast tf1 = new TimedForecast();
        TimedForecast tf2 = new TimedForecast();

        // row.type: 0 (single), 1 (double)
        // row.contentType: 0 (row.map.type==title), 1 (row.map.type==image), 2 (row.map.type==text)
        // row.map.title:
        // row.map.type:
        // row.map.value:
        // row.map.value1:
        // row.map.value2:

        for (Row row : slot.getListOfRows()) {

            boolean isDoubleValue = isDoubleValueRow(row);

            if (row.getContentType() == ROW_CONTENT_TYPE_TITLE) {
                extractDataFromRowTitle(row, tf1, isDoubleValue ? ROW_MAP_KEY_VALUE1 : ROW_MAP_KEY_VALUE);
                extractDataFromRowTitle(row, tf2, isDoubleValue ? ROW_MAP_KEY_VALUE2 : ROW_MAP_KEY_VALUE);
            }
            else if (row.getContentType() == ROW_CONTENT_TYPE_IMAGE) {
                extractDataFromRowImage(row, tf1, isDoubleValue ? ROW_MAP_KEY_VALUE1 : ROW_MAP_KEY_VALUE);
                extractDataFromRowImage(row, tf2, isDoubleValue ? ROW_MAP_KEY_VALUE2 : ROW_MAP_KEY_VALUE);
            }
            else if (row.getContentType() == ROW_CONTENT_TYPE_TEXT) {
                extractDataFromRowText(row, tf1, isDoubleValue ? ROW_MAP_KEY_VALUE1 : ROW_MAP_KEY_VALUE);
                extractDataFromRowText(row, tf2, isDoubleValue ? ROW_MAP_KEY_VALUE2 : ROW_MAP_KEY_VALUE);
            }
            else {
                LOGGER.warning("Unknown row content type: " + row.getContentType());
                throw new MeteogramDataNotValidException();
            }
        }

        return List.of(tf1, tf2);
    }

    private boolean isDoubleValueRow(Row row) {

        return row.getType() == ROW_TYPE_DOUBLE;
    }

    /**
     * Extracts the title information from the given row and sets it in the provided TimedForecast instance.
     * Validates that the row contains the expected "title" content type before processing.
     *
     * @param row             The row object containing key-value pairs, including the title information.
     * @param tf              The TimedForecast instance where the extracted title will be set.
     * @param valueMapKeyName The key used to retrieve the title value from the row's map.
     * @throws MeteogramDataNotValidException If the row content type does not match the expected title type.
     */
    private void extractDataFromRowTitle(Row row, TimedForecast tf, String valueMapKeyName)
        throws MeteogramDataNotValidException {

        if (!ROW_MAP_VALUE_FOR_KEY_TYPE_TITLE.equals(row.getMap().get(ROW_MAP_KEY_TYPE))) {
            LOGGER.warning("Unexpected row content type %s with map type %s".formatted(row.getContentType(), row.getMap().get(ROW_MAP_KEY_TYPE)));
            throw new MeteogramDataNotValidException();
        }

        tf.setTitle(row.getMap().get(valueMapKeyName));
    }

    private void extractDataFromRowImage(Row row, TimedForecast tf, String valueMapKeyName)
        throws MeteogramDataNotValidException {

        if (!ROW_MAP_VALUE_FOR_KEY_TYPE_IMAGE.equals(row.getMap().get(ROW_MAP_KEY_TYPE))) {
            LOGGER.warning("Unexpected row content type %s with map type %s".formatted(row.getContentType(), row.getMap().get(ROW_MAP_KEY_TYPE)));
            throw new MeteogramDataNotValidException();
        }

        tf.setIcon(ArpavToLaMetricTimeIconConverter.getIconId(row.getMap().get(valueMapKeyName)));
    }

    private void extractDataFromRowText(Row row, TimedForecast tf, String valueMapKeyName)
        throws MeteogramDataNotValidException {

        if (!ROW_MAP_VALUE_FOR_KEY_TYPE_TEXT.equals(row.getMap().get(ROW_MAP_KEY_TYPE))) {
            LOGGER.warning("Unexpected row content type %s with map type %s".formatted(row.getContentType(), row.getMap().get(ROW_MAP_KEY_TYPE)));
            throw new MeteogramDataNotValidException();
        }

        String title = row.getMap().get(ROW_MAP_KEY_TITLE);
        String value = row.getMap().get(valueMapKeyName);

        switch (title) {
        case ROW_MAP_VALUE_FOR_KEY_TITLE_TEMPERATURA:
            tf.setTemperature(value);
            break;
        case ROW_MAP_VALUE_FOR_KEY_TITLE_TEMPERATURA2000M:
            tf.setTemperature2000(value);
            break;
        case ROW_MAP_VALUE_FOR_KEY_TITLE_TEMPERATURA3000M:
            tf.setTemperature3000(value);
            break;
        case ROW_MAP_VALUE_FOR_KEY_TITLE_PRECIPITAZIONI:
            tf.setPrecipitation(value);
            break;
        case ROW_MAP_VALUE_FOR_KEY_TITLE_PROBABILITA_PRECIPITAZIONI:
            tf.setPrecipitationProbability(value);
            break;
        case ROW_MAP_VALUE_FOR_KEY_TITLE_QUOTA_NEVE:
            tf.setSnow(value);
            break;
        case ROW_MAP_VALUE_FOR_KEY_TITLE_ATTENDIBILITA:
            tf.setReliability(value);
        }
    }

    private void loadData() {

        LOGGER.info("Loading data...");

        boolean loadResult = XMLParser.getXML(null, Util.getXML(null));

        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.info("Loading completed with result: " + loadResult);
        }
    }
}
