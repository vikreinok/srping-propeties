package ch.home.properties.springproperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @Value("${transation.1.en}")
    private String translation;

    @GetMapping("/translation")
    public String getTranslation() {
        return translation;
    }

}