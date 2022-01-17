import readers.CSVReader;
import writers.XMLWriter;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        CSVReader csvReader = new CSVReader();
        // List<String[]> list = csvReader.read("C:\\Users\\yoles\\Desktop\\petel\\hospital\\src\\main\\resources\\MadaReports.csv");
        String writePath = "C:\\Users\\yoles\\Desktop\\petel\\source\\LEBTESTS\\test";
        String resourcePath = "C:\\Users\\yoles\\Desktop\\petel\\hospital\\src\\main\\resources\\LabTests.csv";
        List<String[]> list = csvReader.read(resourcePath);
        XMLWriter xmlWriter = new XMLWriter();
        xmlWriter.write(list, writePath);
    }
}
