package de.exxcellent.challenge;

import de.exxcellent.challenge.data.Data;

import java.util.List;

public class Calculation {

    /**
     * Module method to get the smallest Spread
     * @param dataList
     * @param <T>
     * @return
     */
    public static <T extends Data> String getIdentifierWithSmallestSpread(List<T> dataList) {
        String minIdentifier = null;
        int minSpread = Integer.MAX_VALUE;

        for (T data : dataList) {
            if (data.getSpread() < minSpread) {
                minSpread = data.getSpread();
                minIdentifier = data.getId();
            }
        }
        return minIdentifier;
    }
}
