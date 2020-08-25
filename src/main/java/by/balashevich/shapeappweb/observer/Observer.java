package by.balashevich.shapeappweb.observer;

import java.util.EventObject;

public interface Observer<T extends EventObject> {
    void actionPerformed(T eventObject);
}
