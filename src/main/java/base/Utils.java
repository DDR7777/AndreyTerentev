package base;

import entity.MetalsAndColorsData;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<String> getExpectedResults(MetalsAndColorsData data) {
        List<String> results = new ArrayList<>();
        results.add("Summary: " + (data.summary.get(0) + data.summary.get(1)));
        results.add("Elements: " + String.join(", ", data.elements));
        results.add("Color: " + data.color);
        results.add("Metal: " + data.metals);
        results.add("Vegetables: " + String.join(", ", data.vegetables));
        return results;
    }
}
