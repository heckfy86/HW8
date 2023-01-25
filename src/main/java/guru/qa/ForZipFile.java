package guru.qa;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ForZipFile {
    public static void createZipFile () throws URISyntaxException {
        List<String> filePaths = Arrays.asList("src/main/resources/sample.pdf", "src/main/resources/shop.xlsx","src/main/resources/shop.csv");

        String zipPath = "src/test/resources/output.zip";

        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipPath))) {
            for (String filePath : filePaths) {
                File fileToZip = new File(filePath);
                zipOut.putNextEntry(new ZipEntry(fileToZip.getName()));
                Files.copy(fileToZip.toPath(), zipOut);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
