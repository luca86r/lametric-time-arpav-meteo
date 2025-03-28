package com.lucarubin;

import java.util.HashMap;
import java.util.Map;

/**
 * Convert ARPAV icons to LaMetric Time icons
 */
public class ArpavToLaMetricTimeIconConverter {

    private static final Map<String, Integer> ICONS_MAP = new HashMap<>();

    static {

        ICONS_MAP.put("a1.png", 43263); // Sunny
        ICONS_MAP.put("a2.png", 13852); // Sunny with clouds
        ICONS_MAP.put("a3.png", 13852); // Sunny with clouds
        ICONS_MAP.put("a4.png", 13852); // Sunny with clouds
        ICONS_MAP.put("a5.png", 12246); // Clouds
        ICONS_MAP.put("a6.png", 12246); // Clouds);

        ICONS_MAP.put("b1.png", 72); // Rain
        ICONS_MAP.put("b2.png", 72); // Rain
        ICONS_MAP.put("b3.png", 72); // Rain
        ICONS_MAP.put("b4.png", 72); // Rain
        ICONS_MAP.put("b5.png", 72); // Rain
        ICONS_MAP.put("b6.png", 72); // Rain
        ICONS_MAP.put("b7.png", 72); // Rain
        ICONS_MAP.put("b8.png", 72); // Rain
        ICONS_MAP.put("b9.png", 72); // Rain
        ICONS_MAP.put("b10.png", 72); // Rain

        ICONS_MAP.put("c1.png", 43733); // sun with thunderstorm
        ICONS_MAP.put("c2.png", 43733); // sun with thunderstorm
        ICONS_MAP.put("c3.png", 11428);  // Thunderstorm
        ICONS_MAP.put("c4.png", 43733); // sun with thunderstorm
        ICONS_MAP.put("c5.png", 43733); // sun with thunderstorm
        ICONS_MAP.put("c6.png", 43733); // sun with thunderstorm
        ICONS_MAP.put("c7.png", 11428); // Thunderstorm
        ICONS_MAP.put("c8.png", 43733); // sun with thunderstorm
        ICONS_MAP.put("c9.png", 43733); // sun with thunderstorm
        ICONS_MAP.put("c10.png", 11428);  // Thunderstorm

        ICONS_MAP.put("d1.png", 7123); // sun cloudy (one cloud) with snow (one flake)
        ICONS_MAP.put("d2.png", 7123); // sun cloudy (two cloud) with snow (one flake)
        ICONS_MAP.put("d3.png", 7123); // cloudy (two cloud) with snow (one flake)
        ICONS_MAP.put("d4.png", 7123); // cloudy (one cloud) with snow (one flake)
        ICONS_MAP.put("d5.png", 7123); // sun cloudy (one cloud) with snow (three flakes)
        ICONS_MAP.put("d6.png", 7123); // sun cloudy (two cloud) with snow (three flakes)
        ICONS_MAP.put("d7.png", 7123); // cloudy (two cloud) with snow (three flakes)
        ICONS_MAP.put("d8.png", 7123); // sun cloudy (one cloud) with snow (six flakes)
        ICONS_MAP.put("d9.png", 7123); // sun cloudy (two cloud) with snow (six flakes)
        ICONS_MAP.put("d10.png", 7123); // cloudy (two cloud) with snow (six flakes)

        ICONS_MAP.put("e1.png", 160); // sun cloudy (one cloud) with snow (one flake) and rain (one drop)
        ICONS_MAP.put("e2.png", 160); // sun cloudy (two cloud) with snow (one flake) and rain (one drop)
        ICONS_MAP.put("e3.png", 160); // cloudy (two cloud) with snow (one flake) and rain (one drop)
        ICONS_MAP.put("e4.png", 160); // cloudy (one cloud) with snow (one flake) and rain (one drop)
        ICONS_MAP.put("e5.png", 160); // sun cloudy (one cloud) with snow (two flakes) and rain (two drops)
        ICONS_MAP.put("e6.png", 160); // sun cloudy (two cloud) with snow (two flakes) and rain (two drops)
        ICONS_MAP.put("e7.png", 160); // cloudy (two cloud) with snow (two flakes) and rain (two drops)
        ICONS_MAP.put("e8.png", 160); // sun cloudy (one cloud) with snow (three flakes) and rain (three heavy drops)
        ICONS_MAP.put("e9.png", 160); // sun cloudy (two cloud) with snow (three flakes) and rain (three heavy drops)
        ICONS_MAP.put("e10.png", 160); // cloudy (two cloud) with snow (three flakes) and rain (three heavy drops)

        ICONS_MAP.put("f1.png", 676); // sun and fog
        ICONS_MAP.put("f2.png", 2154); // sun, clouds and fog
        ICONS_MAP.put("f3.png", 2154); // sun, big clouds and fog
        ICONS_MAP.put("f4.png", 17054); // fog

        ICONS_MAP.put("g1_0.png", 2672); // wind arrow down
        ICONS_MAP.put("g1_1.png", 2672); // wind arrow left-down
        ICONS_MAP.put("g1_2.png", 2672); // wind arrow left
        ICONS_MAP.put("g1_3.png", 2672); // wind arrow left-up
        ICONS_MAP.put("g1_4.png", 2672); // wind arrow up
        ICONS_MAP.put("g1_5.png", 2672); // wind arrow right-up
        ICONS_MAP.put("g1_6.png", 2672); // wind arrow right
        ICONS_MAP.put("g1_7.png", 2672); // wind arrow right-down
        ICONS_MAP.put("g2_0.png", 2672); // wind strong arrow down
        ICONS_MAP.put("g2_1.png", 2672); // wind strong arrow left-down
        ICONS_MAP.put("g2_2.png", 2672); // wind strong arrow left
        ICONS_MAP.put("g2_3.png", 2672); // wind strong arrow left-up
        ICONS_MAP.put("g2_4.png", 2672); // wind strong arrow up
        ICONS_MAP.put("g2_5.png", 2672); // wind strong arrow right-up
        ICONS_MAP.put("g2_6.png", 2672); // wind strong arrow right
        ICONS_MAP.put("g2_7.png", 2672); // wind strong arrow right-down
        ICONS_MAP.put("g3_0.png", 2672); // wind very strong arrow down
        ICONS_MAP.put("g3_1.png", 2672); // wind very strong arrow left-down
        ICONS_MAP.put("g3_2.png", 2672); // wind very strong arrow left
        ICONS_MAP.put("g3_3.png", 2672); // wind very strong arrow left-up
        ICONS_MAP.put("g3_4.png", 2672); // wind very strong arrow up
        ICONS_MAP.put("g3_5.png", 2672); // wind very strong arrow right-up
        ICONS_MAP.put("g3_6.png", 2672); // wind very strong arrow right
        ICONS_MAP.put("g3_7.png", 2672); // wind very strong arrow right-down

        ICONS_MAP.put("l1.png", 2981); // Thunderstorm
        ICONS_MAP.put("l2.png", 0); // Snow flake, row and drop
        ICONS_MAP.put("l3.png", 3363); // Flag
        ICONS_MAP.put("l4.png", 3363); // Helicopter flag
        ICONS_MAP.put("l5.png", 0); // Snow flake with cold termometer
        ICONS_MAP.put("l6.png", 0); // Smoke warning
        ICONS_MAP.put("l7.png", 0); // T max up
        ICONS_MAP.put("l8.png", 0); // T min down

        ICONS_MAP.put("s1.png", 0); // Sea calm
        ICONS_MAP.put("s2.png", 0); // Sea rough
        ICONS_MAP.put("s3.png", 0); // Sea very rough
        ICONS_MAP.put("s4.png", 0); // Sea storm

        ICONS_MAP.put("t1.png", 0); // T max up
        ICONS_MAP.put("t2.png", 0); // T max left and right
        ICONS_MAP.put("t3.png", 0); // T max down
        ICONS_MAP.put("t4.png", 0); // T min up
        ICONS_MAP.put("t5.png", 0); // T min left and right
        ICONS_MAP.put("t6.png", 0); // T min down
        ICONS_MAP.put("t7.png", 0); // T max and min up
        ICONS_MAP.put("t8.png", 0); // T max and min down
        ICONS_MAP.put("t9.png", 0); // T max down and min up
        ICONS_MAP.put("t10.png", 0); // T max up and min down
        ICONS_MAP.put("t11.png", 0); // T max left and min right
    }

    public static Integer getIconId(String imageName) {

        Integer iconId = ICONS_MAP.get(imageName);
        return iconId == null ? 0 : iconId;
    }

    private ArpavToLaMetricTimeIconConverter() {

    }
}
