package readers.factory;

import readers.Read;

public abstract class AbstractFactory {
    abstract Read getReader(String readerType);
}
