package ch.home.properties.springproperties.service;

import java.util.AbstractMap;

/**
 *
 */
public interface PropertyService {
    String getProperty(String propertyKey, String language, AbstractMap.SimpleEntry<String, String>... keyValuePairs);
}
