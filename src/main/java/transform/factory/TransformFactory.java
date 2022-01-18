package transform.factory;

import transform.LabTestTransforming;
import transform.SerologyTransform;
import transform.Transform;

import java.util.HashMap;
import java.util.Map;

public class TransformFactory extends AbstractFactory {
    private Map<String, Transform> transformers;

    public TransformFactory() {
        transformers = new HashMap<>();
        transformers.put("lab test", new LabTestTransforming());
        transformers.put("serology", new SerologyTransform());
    }

    @Override
    public Transform getTransform(String transformType) {
        return transformers.get(transformType);
    }
}
