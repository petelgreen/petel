package writers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JSONWriter implements Write {
    @Override
    public void write(List<String[]> data, String path) {
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
            map = new LinkedHashMap<String, Object>();
            map.put("mdaCode", string[0]);
            map.put("IDNum", string[1]);
            map.put("IDType", string[2]);
            map.put("firstName", string[3]);
            map.put("lastName", string[4]);
            map.put("city", string[5]);
            map.put("street", string[6]);
            map.put("buildingNumber", string[7]);
            map.put("barcode", string[8]);
            map.put("getDate", string[9]);
            map.put("takeDate", string[10]);
            map.put("resultDate", string[11]);
            jsonArray.add(map);
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

