package transform;

import java.util.ArrayList;
import java.util.List;

public class LabTestTransforming implements Transform {
    private LabTestTransform labTest;

    @Override
    public List<String[]> transform(List<String[]> data) {
        List<String[]> updatedData = new ArrayList<>();
        for (String[] string: data) {
            String[] tmp = new String[string.length + 3];
            int i;
            for (i = 0; i < string.length; i++) {
                tmp[i] = string[i];
            }
            labTest = new LabTestTransform(string[0], string[1]);
            tmp[i] = labTest.getJoinDate();
            tmp[i + 1] = labTest.getHealthCareId();
            tmp[i + 2] = labTest.getHealthCareName();
            updatedData.add(tmp);
        }
        return updatedData;

    }
}
