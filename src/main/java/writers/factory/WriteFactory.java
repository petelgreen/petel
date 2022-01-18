package writers.factory;

import writers.Write;
import writers.types.JSONWriterLengthLimit;
import writers.types.JSONWriterSizeLimit;
import writers.types.SQLWriter;
import writers.types.XMLWriter;

import java.util.LinkedHashMap;
import java.util.Map;

public class WriteFactory extends AbstractFactory{
    private Map<String, Write> writers;

    public WriteFactory() {
        writers = new LinkedHashMap<>();
        writers.put("json length limit", new JSONWriterLengthLimit());
        writers.put("json size limit", new JSONWriterSizeLimit());
        writers.put("xml", new XMLWriter());
        writers.put("sql", new SQLWriter());
    }

    @Override
    public Write getWriter(String writerType) {
        return writers.get(writerType);
    }
}
