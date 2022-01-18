package transform;

import health_care_provider.errors.InvalidIdException;

import java.util.ArrayList;
import java.util.List;

public class SerologyTransform extends TransformBasic implements Transform{
    @Override
    public void transform(List<String[]> data) {
        List<String[]> updatedData = new ArrayList<>();
        for (String[] string: data) {
            int arrLength = string.length;
            int antidotes = Integer.parseInt(string[8]);
            int kitNumber = Integer.parseInt(string[9]);
            String[] tmp = copyArrPlusPlaces(string, 1);
            tmp[arrLength] = isEnoughAntidotes(antidotes, kitNumber);
            updatedData.add(tmp);
        }
        copyList(data, updatedData);
    }

    private String isEnoughAntidotes(int antidotes, int kitNumber) {
        if ((kitNumber == 15) && (antidotes > 500)) {
            return "yes";
        }
        if ((kitNumber == 16) && (antidotes > 1500)) {
            return "yes";
        }
        if ((kitNumber == 17) && (antidotes > 3000)) {
            return "yes";
        }
        return "no";
    }
}
