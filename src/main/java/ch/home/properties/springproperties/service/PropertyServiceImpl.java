package ch.home.properties.springproperties.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.Properties;

@Service
public class PropertyServiceImpl implements PropertyService {

    private final Properties properties;

    public PropertyServiceImpl() throws IOException {
        this.properties = new Properties();
        this.properties.load(getClass().getClassLoader().getResourceAsStream("i18.properties"));
    }

    @Override
    public String getProperty(String propertyKey, String language, AbstractMap.SimpleEntry<String, String>... keyValuePairs) {
        String propertyValue = properties.getProperty(propertyKey + "." + language);
        for (AbstractMap.SimpleEntry<String, String> keyValuePair : keyValuePairs) {
            propertyValue = propertyValue.replace("#{'$'}", "");
            propertyValue = propertyValue.replace("{" + keyValuePair.getKey() + "}", keyValuePair.getValue());
        }
        return propertyValue;
    }

}