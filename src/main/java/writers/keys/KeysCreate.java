package writers.keys;

import java.util.ArrayList;
import java.util.List;

public class KeysCreate {
    public List<String> getMadaRepoKeys() {
        List<String> keys = new ArrayList<>();
        keys.add("mdaCode");
        keys.add("IDNum");
        keys.add("IDType");
        keys.add("firstName");
        keys.add("lastName");
        keys.add("City");
        keys.add("Street");
        keys.add("BuildingNumber");
        keys.add("barcode");
        keys.add("getDate");
        keys.add("takeDate");
        keys.add("resultDate");
        return keys;
    }
    public List<String> getPositivePeopleKeys() {
        List<String> keys = new ArrayList<>();
        keys.add("IDNum");
        keys.add("IDType");
        keys.add("firstName");
        keys.add("lastName");
        keys.add("City");
        keys.add("Street");
        keys.add("BuildingNumber");
        keys.add("barcode");
        keys.add("birthDate");
        keys.add("labCode");
        keys.add("takeDate");
        keys.add("resultDate");
        keys.add("stickerNumber");
        keys.add("resultTestCorona");
        keys.add("variant");
        keys.add("testType");
        return keys;
    }
    public List<String> getLabKeys() {
        List<String> keys = new ArrayList<>();
        keys.add("IDNum");
        keys.add("IDType");
        keys.add("firstName");
        keys.add("lastName");
        keys.add("resultDate");
        keys.add("birthDate");
        keys.add("labCode");
        keys.add("stickerNumber");
        keys.add("resultTestCorona");
        keys.add("variant");
        keys.add("testType");
        keys.add("joinDate");
        keys.add("healthCareId");
        keys.add("healthCareName");
        return keys;
    }
}
