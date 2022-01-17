package writers.types;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import writers.Write;
import writers.Writer;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.*;

public class XMLWriter extends Writer implements Write {
    @Override
    public void write(List<String[]> data, String path, List<String> keys) {
        XmlMapper mapper = new XmlMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        int filesCount = 1;
        int objectsCount = 0;
        File file = null;
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        ArrayList<Map<String, Object>> xmlList = new ArrayList<>();
        for (String[] string:  data) {
            if (objectsCount == 600) {
                file = new File( path + filesCount + ".xml");
                try {
                    mapper.writer().withRootName("Mada").writeValue(file, xmlList);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                xmlList = new ArrayList<>();
                filesCount++;
                objectsCount = 0;
            }
            xmlList.add(CreateValuesANDKeysMap(keys, string));
            objectsCount++;
        }
        file = new File(path + filesCount + ".xml");
        try {
            mapper.writer().withRootName("Mada").writeValue(file, xmlList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
