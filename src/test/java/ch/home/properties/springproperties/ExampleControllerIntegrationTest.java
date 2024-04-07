package ch.home.properties.springproperties;

import ch.home.properties.springproperties.service.PropertyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({ExampleController.class, PropertyService.class})
class ExampleControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getExampleProperty_en_returnsEnPropertyWithValues() throws Exception {

        mockMvc.perform(get("/translation")
                        .header("x-language", "en")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("I want to test my car"));
    }

    @Test
    void getExampleProperty_de_returnsEnPropertyWithValues() throws Exception {

        mockMvc.perform(get("/translation")
                        .header("x-language", "de")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Ich will mein Auto testen"));
    }

}