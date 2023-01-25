package guru.qa;

import com.codeborne.pdftest.PDF;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.codeborne.xlstest.XLS;


import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static org.apache.commons.lang3.StringUtils.substring;
import static org.assertj.core.api.Assertions.assertThat;


public class CheckFiles {


    @DisplayName("Демонстрационный тест")
    @Test
    void simpleTest() {
        Assertions.assertTrue(3 > 2);
    }

    @Test
    void openZipFile() throws IOException, CsvException {
        final String textInPDF = "A Simple PDF File";
        final String textInXLSX = "Централизованное пекарное производство";
        final String textCSV = "test";

        ZipFile zipFile = new ZipFile("src/test/resources/output.zip");

        Enumeration<? extends ZipEntry> entries = zipFile.entries();

        while (entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();

            if (entry.getName().contains(".pdf")) {
                PDF content = new PDF(zipFile.getInputStream(entry));
                assertThat(content.text).contains(textInPDF);
            }
            else if (entry.getName().contains(".xlsx")) {
                XLS content = new XLS(zipFile.getInputStream(entry));
                assertThat(content.excel.getSheetAt(0).getRow(1).getCell(1).getStringCellValue()).contains(textInXLSX);
            }
            else if (entry.getName().contains(".csv")) {
                {
                    CSVReader reader = new CSVReader(new InputStreamReader(zipFile.getInputStream(entry)));
                    List<String[]> content = reader.readAll();
                    System.out.println(content.get(0)[0]);
                    assertThat(content.get(0)[0]).contains(textCSV);
                }
            }
        }
    }
}
