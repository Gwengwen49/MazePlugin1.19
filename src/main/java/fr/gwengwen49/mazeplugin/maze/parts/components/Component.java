package fr.gwengwen49.mazeplugin.maze.parts.components;

import fr.gwengwen49.mazeplugin.maze.parts.Part;
import fr.gwengwen49.mazeplugin.maze.registry.RegistryEntry;
import org.bukkit.Location;


@FunctionalInterface
public interface Component<T extends Part> extends RegistryEntry {

    void generate(Location loc);

    default T getPart()
    {
        return (T)this;
    }
}
