package qa.annenko;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import java.io.*;

import static com.codeborne.selenide.Selenide.$;

public class JsonParse {

    ClassLoader classLoader = JsonParse.class.getClassLoader();

    @Test
    void parseJsonTest() throws Exception {
        InputStream inputStream = classLoader.getResourceAsStream("Flights.json");


    }
}
