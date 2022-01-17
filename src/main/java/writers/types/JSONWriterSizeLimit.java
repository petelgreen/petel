package writers.types;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import writers.Write;
import writers.Writer;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JSONWriterSizeLimit extends Writer implements Write {
    @Override
    public void write(List<String[]> data, String path, List<String> keys) {
        int filesCount = 1;
        int fileSize = 0;
        File file = new File(path + filesCount + ".json");
        JSONObject jsonObject;
        JSONArray jsonArray = new JSONArray();
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        for (String[] string:  data) {
            if (fileSize / (1024 * 1024) > 20) {
                file = new File(path + filesCount + ".json");
                try {
                    mapper.writeValue(file, jsonArray);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                jsonArray = new JSONArray();
                filesCount++;
                fileSize = 0;
            }
            jsonObject = new JSONObject();
            Map<String, Object> map = CreateValuesANDKeysMap(keys, string);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                jsonObject.put(entry.getKey(), entry.getValue());
            }
            jsonArray.add(jsonObject);
            fileSize += jsonObject.size();
        }
        try {
            mapper.writeValue(file, jsonArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
