package fr.gwengwen49.mazeplugin.maze.parts;

import fr.gwengwen49.mazeplugin.maze.registry.RegistryEntry;
import org.bukkit.Location;

import java.util.Random;
@FunctionalInterface
public interface Part extends RegistryEntry {

    Random random = new Random();
    void generate(Location startPos);

}
