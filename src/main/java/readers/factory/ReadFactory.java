package readers.factory;
import readers.types.CSVReader;
import readers.Read;

import java.util.LinkedHashMap;
import java.util.Map;

public class ReadFactory extends AbstractFactory{
    private Map<String, Read> readers;

    public ReadFactory() {
        readers = new LinkedHashMap<>();
        readers.put("csv", new CSVReader());
    }
    @Override
    public Read getReader(String readerType) {
        return readers.get(readerType);
    }
}
