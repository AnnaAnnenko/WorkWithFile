package qa.annenko;

import com.codeborne.selenide.Selenide;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import qa.annenko.models.Flights;

import java.io.*;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.LIST;

public class JsonParse {

    ClassLoader classLoader = JsonParse.class.getClassLoader();
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void parseJsonTest() throws Exception {
        InputStream inputStream = classLoader.getResourceAsStream("Flights.json");
        Flights flight = objectMapper.readValue(new InputStreamReader(inputStream), Flights.class);
        assertThat(flight.flightNumber).isEqualTo("SU6454");
        assertThat(flight.destination).isEqualTo("Orenburg");
        assertThat(flight.departureTime).isEqualTo("5:25");
        assertThat(flight.cabinCrew).contains("Ivanov", "Petrov", "Sidorov");
        assertThat(flight.meal.hotMeal).isEqualTo(120);
        assertThat(flight.meal.water).isEqualTo(1500);
        assertThat(flight.meal.juice).isEqualTo(1000);
    }
}
