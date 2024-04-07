package ch.home.properties.springproperties;

import ch.home.properties.springproperties.service.PropertyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.AbstractMap;

@RestController
public class ExampleController {
    private final PropertyService propertyService;

    public ExampleController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("/translation")
    public String getTranslation(@RequestHeader("x-language") String language) {
        return propertyService.getProperty("transation.1", language, getKeyValuePairsFromDb(language));
    }

    /**
     * Get the key value pairs from the database Mock.
     *
     * @param language en or de
     * @return the key value pairs
     */
    AbstractMap.SimpleEntry<String, String>[] getKeyValuePairsFromDb(String language) {
        AbstractMap.SimpleEntry<String, String>[] keyValuePairs;
        if ("en".equals(language)) {
            keyValuePairs = new AbstractMap.SimpleEntry[]{
                    new AbstractMap.SimpleEntry("action", "test"),
                    new AbstractMap.SimpleEntry("program_name", "car")
            };
        } else if ("de".equals(language)) {
            keyValuePairs = new AbstractMap.SimpleEntry[]{
                    new AbstractMap.SimpleEntry("action", "testen"),
                    new AbstractMap.SimpleEntry("program_name", "Auto")
            };
        } else {
            throw new IllegalArgumentException("Unsupported language: " + language);
        }
        return keyValuePairs;
    }

}