package com.lucarubin;

import java.util.HashMap;
import java.util.Map;

/**
 * Convert ARPAV icons to LaMetric Time icons
 */
public class ArpavToLaMetricTimeIconConverter {

    private static Map<String, Integer> iconsMap = new HashMap<>();

    static {

        iconsMap.put("a1.png", 43263); // Sunny
        iconsMap.put("a2.png", 13852); // Sunny with clouds
        iconsMap.put("a3.png", 13852); // Sunny with clouds
        iconsMap.put("a4.png", 13852); // Sunny with clouds
        iconsMap.put("a5.png", 12246); // Clouds
        iconsMap.put("a6.png", 12246); // Clouds);

        iconsMap.put("b1.png", 72); // Rain
        iconsMap.put("b2.png", 72); // Rain
        iconsMap.put("b3.png", 72); // Rain
        iconsMap.put("b4.png", 72); // Rain
        iconsMap.put("b5.png", 72); // Rain
        iconsMap.put("b6.png", 72); // Rain
        iconsMap.put("b7.png", 72); // Rain
        iconsMap.put("b8.png", 72); // Rain
        iconsMap.put("b9.png", 72); // Rain
        iconsMap.put("b10.png", 72); // Rain

        iconsMap.put("c1.png", 43733); // sun with thunderstorm
        iconsMap.put("c2.png", 43733); // sun with thunderstorm
        iconsMap.put("c3.png", 11428);  // Thunderstorm
        iconsMap.put("c4.png", 43733); // sun with thunderstorm
        iconsMap.put("c5.png", 43733); // sun with thunderstorm
        iconsMap.put("c6.png", 43733); // sun with thunderstorm
        iconsMap.put("c7.png", 11428); // Thunderstorm
        iconsMap.put("c8.png", 43733); // sun with thunderstorm
        iconsMap.put("c9.png", 43733); // sun with thunderstorm
        iconsMap.put("c10.png", 11428);  // Thunderstorm

        iconsMap.put("d1.png", 7123); // sun cloudy (one cloud) with snow (one flake)
        iconsMap.put("d2.png", 7123); // sun cloudy (two cloud) with snow (one flake)
        iconsMap.put("d3.png", 7123); // cloudy (two cloud) with snow (one flake)
        iconsMap.put("d4.png", 7123); // cloudy (one cloud) with snow (one flake)
        iconsMap.put("d5.png", 7123); // sun cloudy (one cloud) with snow (three flakes)
        iconsMap.put("d6.png", 7123); // sun cloudy (two cloud) with snow (three flakes)
        iconsMap.put("d7.png", 7123); // cloudy (two cloud) with snow (three flakes)
        iconsMap.put("d8.png", 7123); // sun cloudy (one cloud) with snow (six flakes)
        iconsMap.put("d9.png", 7123); // sun cloudy (two cloud) with snow (six flakes)
        iconsMap.put("d10.png", 7123); // cloudy (two cloud) with snow (six flakes)

        iconsMap.put("e1.png", 160); // sun cloudy (one cloud) with snow (one flake) and rain (one drop)
        iconsMap.put("e2.png", 160); // sun cloudy (two cloud) with snow (one flake) and rain (one drop)
        iconsMap.put("e3.png", 160); // cloudy (two cloud) with snow (one flake) and rain (one drop)
        iconsMap.put("e4.png", 160); // cloudy (one cloud) with snow (one flake) and rain (one drop)
        iconsMap.put("e5.png", 160); // sun cloudy (one cloud) with snow (two flakes) and rain (two drops)
        iconsMap.put("e6.png", 160); // sun cloudy (two cloud) with snow (two flakes) and rain (two drops)
        iconsMap.put("e7.png", 160); // cloudy (two cloud) with snow (two flakes) and rain (two drops)
        iconsMap.put("e8.png", 160); // sun cloudy (one cloud) with snow (three flakes) and rain (three heavy drops)
        iconsMap.put("e9.png", 160); // sun cloudy (two cloud) with snow (three flakes) and rain (three heavy drops)
        iconsMap.put("e10.png", 160); // cloudy (two cloud) with snow (three flakes) and rain (three heavy drops)

        iconsMap.put("f1.png", 676); // sun and fog
        iconsMap.put("f2.png", 2154); // sun, clouds and fog
        iconsMap.put("f3.png", 2154); // sun, big clouds and fog
        iconsMap.put("f4.png", 17054); // fog

        iconsMap.put("g1_0.png", 2672); // wind arrow down
        iconsMap.put("g1_1.png", 2672); // wind arrow left-down
        iconsMap.put("g1_2.png", 2672); // wind arrow left
        iconsMap.put("g1_3.png", 2672); // wind arrow left-up
        iconsMap.put("g1_4.png", 2672); // wind arrow up
        iconsMap.put("g1_5.png", 2672); // wind arrow right-up
        iconsMap.put("g1_6.png", 2672); // wind arrow right
        iconsMap.put("g1_7.png", 2672); // wind arrow right-down
        iconsMap.put("g2_0.png", 2672); // wind strong arrow down
        iconsMap.put("g2_1.png", 2672); // wind strong arrow left-down
        iconsMap.put("g2_2.png", 2672); // wind strong arrow left
        iconsMap.put("g2_3.png", 2672); // wind strong arrow left-up
        iconsMap.put("g2_4.png", 2672); // wind strong arrow up
        iconsMap.put("g2_5.png", 2672); // wind strong arrow right-up
        iconsMap.put("g2_6.png", 2672); // wind strong arrow right
        iconsMap.put("g2_7.png", 2672); // wind strong arrow right-down
        iconsMap.put("g3_0.png", 2672); // wind very strong arrow down
        iconsMap.put("g3_1.png", 2672); // wind very strong arrow left-down
        iconsMap.put("g3_2.png", 2672); // wind very strong arrow left
        iconsMap.put("g3_3.png", 2672); // wind very strong arrow left-up
        iconsMap.put("g3_4.png", 2672); // wind very strong arrow up
        iconsMap.put("g3_5.png", 2672); // wind very strong arrow right-up
        iconsMap.put("g3_6.png", 2672); // wind very strong arrow right
        iconsMap.put("g3_7.png", 2672); // wind very strong arrow right-down

        iconsMap.put("l1.png", 2981); // Thunderstorm
        iconsMap.put("l2.png", 0); // Snow flake, row and drop
        iconsMap.put("l3.png", 3363); // Flag
        iconsMap.put("l4.png", 3363); // Helicopter flag
        iconsMap.put("l5.png", 0); // Snow flake with cold termometer
        iconsMap.put("l6.png", 0); // Smoke warning
        iconsMap.put("l7.png", 0); // T max up
        iconsMap.put("l8.png", 0); // T min down

        iconsMap.put("s1.png", 0); // Sea calm
        iconsMap.put("s2.png", 0); // Sea rough
        iconsMap.put("s3.png", 0); // Sea very rough
        iconsMap.put("s4.png", 0); // Sea storm

        iconsMap.put("t1.png", 0); // T max up
        iconsMap.put("t2.png", 0); // T max left and right
        iconsMap.put("t3.png", 0); // T max down
        iconsMap.put("t4.png", 0); // T min up
        iconsMap.put("t5.png", 0); // T min left and right
        iconsMap.put("t6.png", 0); // T min down
        iconsMap.put("t7.png", 0); // T max and min up
        iconsMap.put("t8.png", 0); // T max and min down
        iconsMap.put("t9.png", 0); // T max down and min up
        iconsMap.put("t10.png", 0); // T max up and min down
        iconsMap.put("t11.png", 0); // T max left and min right


    }


}
