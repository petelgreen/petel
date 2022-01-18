package transform.vailidation;

import java.util.*;

public class SerologyTestsValidation {

    public void valid(List<String[]> data) {
        Set<Boolean> validations;
        List<String[]> toDelete = new ArrayList<>();
        for (String[] string: data) {
            validations = new HashSet<>();
            String idNum = string[0];
            int idType = Integer.parseInt(string[1]);
            String labcode = string[6];
            validations.add(isIDNumValid(idNum, idType));
            validations.add(isLengthValid(string));
            validations.add(isLabcodeValid(labcode));
            if (validations.contains(false)) {
                toDelete.add(string);
            }
        }
        for (String[] string: toDelete) {
            data.remove(string);
        }
    }

    private boolean isLengthValid(String[] string) {
        if (string.length == 10) {
            return true;
        }
        return false;
    }

    private boolean isIDNumValid(String idNum, int idType) {
        if (idType == 0) {
            if (idNum.length() != 9 || (!idNum.matches("[0-9]+"))) {
                return false;
            }
        }
        return true;
    }
    private boolean isLabcodeValid(String labcode) {
        if (Character.isDigit(labcode.charAt(0)) && Character.isDigit(labcode.charAt(1))
        && Character.isAlphabetic(labcode.charAt(2)) && Character.isAlphabetic(labcode.charAt(3))
        && Character.isDigit(labcode.charAt(4))) {
            return true;

        }
        return false;
    }
}
