package factories;

import utils.InputHandler;

public interface IObjectFactory<T> {
    T create(InputHandler inputHandler);
}
