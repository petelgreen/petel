package transform;

import health_care_provider.HealthCareInfoProvider;
import health_care_provider.errors.InvalidIdException;
import health_care_provider.models.PersonInsured;

import java.util.ArrayList;
import java.util.List;

public class LabTestTransforming implements Transform {
    private HealthCareInfoProvider healthCare = new HealthCareInfoProvider();
    private PersonInsured person;

    @Override
    public void transform(List<String[]> data) {
        List<String[]> updatedData = new ArrayList<>();
        for (String[] string: data) {
            int arrLength = string.length;
            int idNum = Integer.parseInt(string[0]);
            int idType = Integer.parseInt(string[0]);
            try {
                person = healthCare.fetchInfo(idNum, idType);
            } catch (InvalidIdException e) {
                e.printStackTrace();
            }
            String[] tmp = copyArrPlusPlaces(string, 3);
            tmp[arrLength] = person.getJoinDate().toString();
            tmp[arrLength + 1] = String.valueOf(person.getHealthCareId());
            tmp[arrLength + 2] = person.getHealthCareName();
            updatedData.add(tmp);
        }
        copyList(data, updatedData);
    }


    private String[] copyArrPlusPlaces(String[] arr, int emptyPlaces) {
        String[] tmp = new String[arr.length + emptyPlaces];
        int i;
        for (i = 0; i < arr.length; i++) {
            tmp[i] = arr[i];
        }
        return tmp;
    }
    private String[] copyArr(String[] arr) {
        String[] copy = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }
    private void copyList(List<String[]> data, List<String[]> updatedData) {
        data.clear();
        for (String[] string: updatedData) {
            String[] tmp = copyArr(string);
            data.add(tmp);
        }
    }
}
