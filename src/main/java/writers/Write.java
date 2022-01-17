package writers;

import java.util.List;

public interface Write {
    void write(List<String[]> data, String path, List<String> keys);
}
