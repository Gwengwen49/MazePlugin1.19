package fr.gwengwen49.mazeplugin.maze.parts;

import fr.gwengwen49.mazeplugin.maze.parts.decorations.MazeDecoration;
import fr.gwengwen49.mazeplugin.maze.parts.decorations.SimpleBlockMazeDecoration;
import fr.gwengwen49.mazeplugin.maze.parts.decorations.TreeDecoration;
import fr.gwengwen49.mazeplugin.maze.parts.pieces.Floor;
import fr.gwengwen49.mazeplugin.maze.parts.pieces.wall.Wall;
import fr.gwengwen49.mazeplugin.maze.registry.MazeRegistry;
import fr.gwengwen49.mazeplugin.util.Box;
import fr.gwengwen49.mazeplugin.util.Constants;
import org.bukkit.Material;

public class Parts {


    public static final Wall WALL;
    public static final Wall SMALL_WALL;
    public static final Floor FLOOR;
    public static final SimpleBlockMazeDecoration COBWEB;
    public static final TreeDecoration TREE;

    static
    {
        WALL = new Wall(new Box(8, 45, 8), Direction.RANDOM, Material.STONE, Material.STONE_BRICKS, Material.MOSSY_STONE_BRICKS, Material.MOSSY_COBBLESTONE);
        SMALL_WALL = new Wall(new Box(8, 20, 8), Direction.EAST, Material.STONE, Material.SHROOMLIGHT, Material.WARPED_WART_BLOCK, Material.WARPED_WART_BLOCK);
        FLOOR = new Floor(Material.STONE, Material.STONE, Material.STONE_BRICKS, Material.STONE_BRICKS, Material.MOSSY_STONE_BRICKS, Material.MOSSY_STONE_BRICKS, Material.POLISHED_ANDESITE, Material.GRASS_BLOCK, Material.ANDESITE);
        COBWEB = new SimpleBlockMazeDecoration(MazeDecoration.Type.FLOOR, Material.COBWEB);
        TREE = new TreeDecoration().setLeaves(Material.AZALEA_LEAVES).setTrunk(Material.OAK_LOG).setLeavesRadius(2).setTrunkHeight(7);

     }

     public static void register()
     {
        MazeRegistry.PARTS
                .register(WALL, "wall")
                .register(FLOOR, "floor")
                .register(COBWEB, "cobweb")
                .register(TREE, "tree");


     }
}
