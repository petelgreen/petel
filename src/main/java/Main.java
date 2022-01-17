import readers.CSVReader;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        CSVReader csvReader = new CSVReader();
        List<String[]> list = csvReader.read();
//        for (String[] row : list) {
//            for (String cell : row) {
//                System.out.print(cell + "\t");
//            }
//            System.out.println();
//        }
        
    }
}
