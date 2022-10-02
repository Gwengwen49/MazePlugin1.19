package fr.gwengwen49.mazeplugin.maze.parts;

import java.util.*;
import java.util.function.BiConsumer;

public class PartsRegistry {

    private static PartsRegistry INSTANCE;
    public PartsRegistry()
    {
        INSTANCE = this;
    }
    private static Map<String, Part> PARTSID = new HashMap<>();
    private static List<Part> PARTS = new ArrayList<>();


    public static <T extends Part> PartsRegistry register(T part, String registry_name){
        PARTSID.put(registry_name, part);
        PARTS.add(part);
        return INSTANCE;
    }

    public static Part getPartFromName(String name)
    {
        Part part = PARTSID.get(name);
        return part;
    }

    public static List<? extends Part> getParts()
    {
    return PARTS;
    }
}
