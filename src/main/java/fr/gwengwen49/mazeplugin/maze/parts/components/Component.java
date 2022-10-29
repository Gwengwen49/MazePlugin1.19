package fr.gwengwen49.mazeplugin.maze.parts.components;

import fr.gwengwen49.mazeplugin.maze.parts.Part;
import fr.gwengwen49.mazeplugin.maze.registry.RegistryEntry;
import org.bukkit.Location;

import java.util.Random;


@FunctionalInterface
public interface Component<T extends Part> extends RegistryEntry {
    Random random = new Random();
    void generate(Location pos, T part);

}
