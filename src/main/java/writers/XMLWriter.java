package writers;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import transform.LabTestTransform;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class XMLWriter implements Write{
    @Override
    public void write(List<String[]> data, String path) {
        XmlMapper mapper = new XmlMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        LabTestTransform transform;
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
            map = new LinkedHashMap<String, Object>();
            transform = new LabTestTransform(string[0], string[1]);
            map.put("IDNum", string[0]);
            map.put("IDType", string[1]);
            map.put("firstName", string[2]);
            map.put("lastName", string[3]);
            map.put("resultDate", string[4]);
            map.put("birthDate", string[5]);
            map.put("labCode", string[6]);
            map.put("stickerNumber", string[7]);
            map.put("resultTestCorona", string[8]);
            map.put("variant", string[9]);
            map.put("testType", string[10]);
            map.put("joinDate", transform.getJoinDate());
            map.put("healthCareId", transform.getHealthCareId());
            map.put("healthCareName", transform.getHealthCareName());
            xmlList.add(map);
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
