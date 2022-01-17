package transform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PositivePeopleTransforming {

    public List<String[]> transform(List<String[]> madaReports,  List<String[]> labTests) {
        List<String[]> result = new ArrayList<>();
        Map<String, String[]> mdaReportsMap = convertListToMap(madaReports);
        for (String[] labTest: labTests) {
            if (labTest[8].equals("1") && (mdaReportsMap.get(labTest[0])) != null) {
                int currRsltIndex = 0;
                String idNum = labTest[0];
                String[] matchingMadaReport = new String[12];
                copyArr(mdaReportsMap.get(idNum), matchingMadaReport);
                String[] rslt = new String[16];
                currRsltIndex = copyArrayInRange(matchingMadaReport, rslt, 1, 8, currRsltIndex);
                currRsltIndex = copyArrayInRange(labTest, rslt, 5, 6, currRsltIndex);
                currRsltIndex = copyArrayInRange(matchingMadaReport, rslt, 10, 11, currRsltIndex);
                currRsltIndex = copyArrayInRange(labTest, rslt, 7, 10, currRsltIndex);
                result.add(rslt);
            }
        }
        return result;
    }

    private Map<String, String[]> convertListToMap(List<String[]> list) {
        Map<String, String[]> map = new HashMap<>();
        for (String[] string: list) {
            String[] tmp =  copyArray(string);
            map.put(string[1], tmp);
        }
        return map;
    }
    private String[] copyArray(String[] arr) {
        String[] copy = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    private void copyArr(String[] arr, String[] copy) {
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
    }

    private int copyArrayInRange(String[] arr, String[] copy, int start, int end, int x){
        for (int i = start; i <= end; i++) {
            copy[x] = arr[i];
            x++;
        }
        return x;
    }
}
