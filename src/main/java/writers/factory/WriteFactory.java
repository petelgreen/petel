package writers.factory;

import writers.Write;
import writers.types.JSONWriter;
import writers.types.XMLWriter;

import java.util.LinkedHashMap;
import java.util.Map;

public class WriteFactory extends AbstractFactory{
    private Map<String, Write> writers;

    public WriteFactory() {
        writers = new LinkedHashMap<>();
        writers.put("json", new JSONWriter());
        writers.put("xml", new XMLWriter());
    }

    @Override
    public Write getWriter(String writerType) {
        return writers.get(writerType);
    }
}
