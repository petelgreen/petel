package writers.factory;

import writers.Write;

public abstract class AbstractFactory {
    abstract Write getWriter(String writerType);
}
