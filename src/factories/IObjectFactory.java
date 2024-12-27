package factories;

import core.InputHandler;

public interface IObjectFactory<T> {
    T create(InputHandler inputHandler);
    T createFromRowParts(String[] parts);
}
