package fr.gwengwen49.mazeplugin.maze.parts.components;

import fr.gwengwen49.mazeplugin.maze.parts.pieces.wall.Wall;
import fr.gwengwen49.mazeplugin.maze.registry.MazeRegistry;
import org.bukkit.Location;
import org.bukkit.Material;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;


public class Components {
    public static final Component<Wall> TEST;

    static {
        TEST = (pos, part) -> {
            if (Component.random.nextInt(5) == 1) {
                pos.getBlock().setType(Material.MAGMA_BLOCK);
            }};
    }


    public static void register() {
        MazeRegistry.COMPONENTS.register(TEST, "test");
    }

}

