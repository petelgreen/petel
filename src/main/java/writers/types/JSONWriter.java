package writers.types;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import writers.Write;
import writers.Writer;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JSONWriter extends Writer implements Write {
    @Override
    public void write(List<String[]> data, String path, List<String> keys) {
        int filesCount = 1;
        int objectsCount = 0;
        File file = null;
        JSONArray jsonArray = new JSONArray();
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        Map<String, Object> map = new LinkedHashMap<String, Object>();
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
                map = null;
            }
            jsonArray.add(CreateValuesANDKeysMap(keys, string));
            objectsCount++;
}
    file = new File(path + filesCount + ".json");
    try {
        mapper.writeValue(file, jsonArray);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}

