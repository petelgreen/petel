package transform.factory;

import transform.Transform;

public abstract class AbstractFactory {
    abstract Transform getTransform(String transformType);
}
