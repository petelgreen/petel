package transform.vailidation;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SerologyTestsValidation {

    public void valid(List<String[]> data) {
        Set<Boolean> validations;
        for (String[] string: data) {
            validations = new HashSet<>();
            String idNum = string[0];
            int idType = Integer.parseInt(string[1]);
            String labcode = string[6];
            validations.add(isIDNumValid(idNum, idType));
            validations.add(isLabcodeValid(labcode));
            if (validations.contains(false)) {
                data.remove(string);
            }
        }
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
