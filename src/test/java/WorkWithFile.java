import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import java.io.*;

import static com.codeborne.selenide.Selenide.$;

public class WorkWithFile {

    @Test
    void selenideFileDownload() throws Exception {
        Selenide.open("https://github.com/junit-team/junit5/blob/main/README.md");
        File downloadFile = $("#raw-url").download();
        try (InputStream is = new FileInputStream(downloadFile)) {
            byte[] fileSource = is.readAllBytes();

        }
    }


    }
}
