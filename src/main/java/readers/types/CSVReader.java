package readers.types;

import com.opencsv.CSVReaderBuilder;
import readers.Read;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVReader implements Read {

    @Override
    public List<String[]> read(String path) {
        File file = new File(path);
        List<String[]> allData = null;
        {
            try {
                FileReader fileReader = new FileReader(file);
                com.opencsv.CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();
                {
                    try {
                        allData = csvReader.readAll();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        return allData;
    }
}
