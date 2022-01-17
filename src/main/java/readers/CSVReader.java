package readers;

import com.opencsv.CSVReaderBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVReader implements Read {

    @Override
    public List<String[]> read() {
        File file = new File("C:\\Users\\yoles\\Desktop\\petel\\hospital\\src\\main\\resources\\MadaReports.csv");
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
