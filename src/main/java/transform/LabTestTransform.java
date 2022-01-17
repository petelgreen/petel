package transform;

import health_care_provider.HealthCareInfoProvider;
import health_care_provider.errors.InvalidIdException;
import health_care_provider.models.PersonInsured;

public class LabTestTransform {
    private HealthCareInfoProvider healthCare = new HealthCareInfoProvider();
    private PersonInsured person;

    public LabTestTransform(String idNum, String idType) {
        healthCare = new HealthCareInfoProvider();
        try {
            person = healthCare.fetchInfo(Integer.parseInt(idNum), Integer.parseInt(idNum));
        } catch (InvalidIdException e) {
            e.printStackTrace();
        }
    }

    public String getJoinDate() {
        return this.person.getJoinDate().toString();
    }

    public String getHealthCareId() {
        return String.valueOf(this.person.getHealthCareId());
    }

    public String getHealthCareName() {
        return this.person.getHealthCareName();
    }
}
