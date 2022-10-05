package fr.gwengwen49.mazeplugin.maze.registry;


import fr.gwengwen49.mazeplugin.maze.ChunkFeature;
import fr.gwengwen49.mazeplugin.maze.parts.Part;
import fr.gwengwen49.mazeplugin.maze.parts.components.Component;
import fr.gwengwen49.mazeplugin.maze.steps.GenStep;
import fr.gwengwen49.mazeplugin.util.Constants;
import fr.gwengwen49.mazeplugin.util.Identity;
import org.checkerframework.checker.index.qual.PolyUpperBound;

import java.util.*;

public class MazeRegistry<T extends RegistryEntry> {

    private Map<String, T> REGISTERABLES = new HashMap<>();
    public static MazeRegistry<Component> COMPONENTS = new MazeRegistry<>();
    public static MazeRegistry<Part> PARTS = new MazeRegistry<>();
    public static MazeRegistry<? extends GenStep> STEPS = new MazeRegistry<>();
    public static MazeRegistry<ChunkFeature<?>> CHUNK_FEATURES = new MazeRegistry<>();


    public MazeRegistry register(T registerable, String name) {
        REGISTERABLES.put(name, registerable);
        return this;
    }
    public MazeRegistry register(Identity<T>... IDs) {
        for(Identity<T> identity : IDs) {
            REGISTERABLES.put(identity.name(), identity.object());
        }
        return this;
    }

    public T getEntry()
    {
        return (T)this;
    }

    public T getFromName(String name) {
        return REGISTERABLES.get(name);

    }

    public List<T> getRegisterables() {
          return new ArrayList<>(REGISTERABLES.values());

    }
}
