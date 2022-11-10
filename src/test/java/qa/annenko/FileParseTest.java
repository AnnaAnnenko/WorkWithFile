package qa.annenko;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class FileParseTest {

    ClassLoader classLoader = FileParseTest.class.getClassLoader();

    @Test
    public void parseZipTest() throws Exception {
        try (ZipFile zipFile = new ZipFile(new File("src/test/resources/TestData.zip"));
             InputStream is = classLoader.getResourceAsStream("TestData.zip")) {
            ZipInputStream zis = new ZipInputStream(is);
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                String entryName = entry.getName();
                switch (entryName) {
                    case "csv.csv":
                        try (InputStream inputStream = zipFile.getInputStream(entry)) {
                            CSVReader csv = new CSVReader(new InputStreamReader(inputStream));
                            List<String[]> content = csv.readAll();
                            String[] row = content.get(1);
                            assertThat(row[0]).isEqualTo("SU6454");
                        }
                        break;
                    case "Excel.xlsx":
                        try (InputStream inputStream = zipFile.getInputStream(entry)) {
                            XLS xls = new XLS(inputStream);
                            assertThat(
                                    xls.excel.getSheetAt(0).getRow(0).getCell(1).getStringCellValue())
                                    .isEqualTo("SU6454");
                        }
                        break;
                    case "PDF.pdf":
                        try (InputStream inputStream = zipFile.getInputStream(entry)) {
                            PDF pdf = new PDF(inputStream);
                            assertThat(pdf.text).contains("SU6454");
                        }
                        break;
                }
            }
        }
    }
}