import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import java.io.File;

public class FileParseTest {

    @Test
    public void parseTest() throws Exception {
        Selenide.open();
        File downloadFile = $().download();

    }
}
