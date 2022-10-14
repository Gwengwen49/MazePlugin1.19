package fr.gwengwen49.mazeplugin.maze.parts.components;

import fr.gwengwen49.mazeplugin.maze.parts.pieces.wall.Wall;
import fr.gwengwen49.mazeplugin.maze.registry.MazeRegistry;
import org.bukkit.Material;


public class Components {
    public static final Component WALL_LEAVES;

    static {

        WALL_LEAVES = new WallLeavesComponent();

        }
    public static void register()
    {
        MazeRegistry.COMPONENTS.register((pos, part) -> {
            if(Component.random.nextInt(5) == 1)
            {
                pos.getBlock().setType(Material.MAGMA_BLOCK);
            }
        }, "test");
    }
}
