package fr.gwengwen49.mazeplugin.maze.parts;


import org.bukkit.Location;
import org.bukkit.entity.Player;

@FunctionalInterface
public interface Tickable<T extends Runnable> {
    void tick(Location location, Player player);
    default T getTask(){
        return (T)this;
    }
}
