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
    private final String accessName;
    private String name;
    private T registerable;
    public static MazeRegistry<Component> COMPONENTS = new MazeRegistry<>("component");
    public static MazeRegistry<Part> PARTS = new MazeRegistry<>("part");
    public static MazeRegistry<GenStep> STEPS = new MazeRegistry<>("step");
    public static MazeRegistry<ChunkFeature<?>> CHUNK_FEATURES = new MazeRegistry<>("chunk_feature");

    public MazeRegistry(String accessName)
    {
        this.accessName = accessName;
    }

    public MazeRegistry register(T registerable, String name) {
        this.name = name;
        this.registerable = registerable;
        REGISTERABLES.put(name, registerable);
        return this;
    }
    public MazeRegistry register(Identity<T>... IDs) {
        for(Identity<T> identity : IDs) {
            this.name = identity.name();
            this.registerable = identity.object();
            REGISTERABLES.put(identity.name(), identity.object());
        }
        return this;
    }

    public T getEntry()
    {
        return (T)this;
    }

    public String getName() {
        return name;
    }

    public String getAccessName() {
        return accessName;
    }
    public T getFromName(String name) {
        return REGISTERABLES.get(name);

    }

    public List<T> getRegisterables() {
          return new ArrayList<>(REGISTERABLES.values());

    }

}
