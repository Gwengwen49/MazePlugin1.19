package fr.gwengwen49.mazeplugin.maze.registry;


import fr.gwengwen49.mazeplugin.maze.parts.Part;

import java.util.*;

public class MazeRegistry<T extends RegistryEntry> {
    private static MazeRegistry INSTANCE;
    public MazeRegistry(){
        INSTANCE = this;
    }
    private Map<String, RegistryEntry> REGISTERABLES = new HashMap<>();

    public MazeRegistry register(T registerable, String name) {
        REGISTERABLES.put(name, registerable);
        return this;
    }

    public static MazeRegistry getInstance() {
        return INSTANCE;
    }

    public T get()
    {
        return (T)this;
    }

    public RegistryEntry getFromName(String name)
    {
        RegistryEntry registryEntry = REGISTERABLES.get(name);
        return registryEntry;
    }

    public List<RegistryEntry> getRegisterables() {
        return new ArrayList<>((Collection<? extends RegistryEntry>) REGISTERABLES.entrySet().iterator().next().getValue());
    }
}
