package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String, Integer> countries = new HashMap<>();

        countries.put("Poland", 312696);
        countries.put("Russia", 17098242);
        countries.put("Ghana", 238533);
        countries.put("Australia", 7682300);
        countries.put("Singapore", 693);

        System.out.println("Country with the largest area: " + selectTheLargestArea(countries));
        System.out.println("Country with the smallest area: " + selectTheSmallestArea(countries));

    }

    private static <K, V extends Comparable<V> > Map.Entry<K, V>
    selectTheLargestArea(Map<K, V> map)
    {
        Map.Entry<K, V> entryWithMaxValue = null;

        for (Map.Entry<K, V> currentEntry : map.entrySet()) {

            if (
                    entryWithMaxValue == null

                            || currentEntry.getValue()
                            .compareTo(entryWithMaxValue.getValue())
                            > 0) {

                entryWithMaxValue = currentEntry;
            }
        }

        return entryWithMaxValue;
    }

    private static <K, V extends Comparable<V> > Map.Entry<K, V>
    selectTheSmallestArea(Map<K, V> map)
    {
        Map.Entry<K, V> entryWithMinValue = null;

        for (Map.Entry<K, V> currentEntry : map.entrySet()) {

            if (
                    entryWithMinValue == null

                            || currentEntry.getValue()
                            .compareTo(entryWithMinValue.getValue())
                            < 0) {

                entryWithMinValue = currentEntry;
            }
        }

        return entryWithMinValue;
    }
}
