package transform;

import java.util.List;

public abstract class TransformBasic {
    public String[] copyArrPlusPlaces(String[] arr, int emptyPlaces) {
        String[] tmp = new String[arr.length + emptyPlaces];
        int i;
        for (i = 0; i < arr.length; i++) {
            tmp[i] = arr[i];
        }
        return tmp;
    }
    public String[] copyArr(String[] arr) {
        String[] copy = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }
    public void copyList(List<String[]> data, List<String[]> updatedData) {
        data.clear();
        for (String[] string: updatedData) {
            String[] tmp = copyArr(string);
            data.add(tmp);
        }
    }
}
