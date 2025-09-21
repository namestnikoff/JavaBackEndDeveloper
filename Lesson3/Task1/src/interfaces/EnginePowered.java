package interfaces;

import models.Engine;

public interface EnginePowered {
    Engine getEngine();
    void startEngine();
    void stopEngine();
    boolean isEngineRunning();
}