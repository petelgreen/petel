package writers.types;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.json.simple.JSONArray;
import writers.Write;
import writers.Writer;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class JSONWriterLengthLimit extends Writer implements Write {
    @Override
    public void write(List<String[]> data, String path, List<String> keys) {
        int filesCount = 1;
        int objectsCount = 0;
        File file = null;
        JSONArray jsonArray = new JSONArray();
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        for (String[] string:  data) {
            if (objectsCount == 500) {
                file = new File(path + filesCount + ".json");
                try {
                    mapper.writeValue(file, jsonArray);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                jsonArray = new JSONArray();
                filesCount++;
                objectsCount = 0;
            }
            jsonArray.add(CreateValuesANDKeysMap(keys, string));
            objectsCount++;
}
    try {
        mapper.writeValue(file, jsonArray);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}

