package writers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class Writer {

    public Map<String, Object> CreateValuesANDKeysMap(List<String> keys, String[] string) {
        Map<String, Object> map = new LinkedHashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            map.put(keys.get(i), string[i]);
        }
        return map;
    }
}
