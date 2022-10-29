package fr.gwengwen49.mazeplugin.maze.registry;


import fr.gwengwen49.mazeplugin.maze.ChunkFeature;
import fr.gwengwen49.mazeplugin.maze.parts.Part;
import fr.gwengwen49.mazeplugin.maze.parts.components.Component;
import fr.gwengwen49.mazeplugin.util.BiValue;
import fr.gwengwen49.mazeplugin.util.Identity;

import java.net.PortUnreachableException;
import java.util.*;

public class MazeRegistry<T extends RegistryEntry> {

    private Map<String, T> REGISTERABLES = new HashMap<>();
    private static Map<String, RegistryEntry> ALL_REGISTERABLES = new HashMap<>();
    private final String accessName;
    private String name;
    public static MazeRegistry<Component<?>> COMPONENTS = new MazeRegistry<>("component");
    public static MazeRegistry<Part> PARTS = new MazeRegistry<>("part");
    public static MazeRegistry<ChunkFeature<?>> CHUNK_FEATURES = new MazeRegistry<>("chunk_feature");

    public MazeRegistry(String accessName)
    {
        this.accessName = accessName;
    }

    public MazeRegistry register(T registerable, String name) {
        this.name = name;
        REGISTERABLES.put(name, registerable);
        ALL_REGISTERABLES.put(name, registerable);
        return this;
    }
    public MazeRegistry register(Identity<T>... IDs) {
        Arrays.stream(IDs).forEach(identity -> this.register(identity.object(), identity.name()));
        return this;
    }

    private T getEntry()
    {
        return (T)this;
    }

    public String getName() {
        return name;
    }

    public String getTypeName() {
        return accessName;
    }

    public String getPath() {
        return accessName + "/" + name;
    }

    public static List<RegistryEntry> getAll() {
        return new ArrayList<>(ALL_REGISTERABLES.values());
    }

    public static<V extends RegistryEntry> V getFromAll(String name)
    {
        return (V) ALL_REGISTERABLES.get(name);
    }
    public T getFromName(String name) {
        return REGISTERABLES.get(name);

    }


    public BiValue<MazeRegistry<T>, List<T>> getRegisterables() {
          return new BiValue<>(this, new ArrayList<>(REGISTERABLES.values()));

    }

    public Class<T> getEntryClass()
    {
        return (Class<T>) this.getEntry().getClass();
    }


}
