package fr.gwengwen49.mazeplugin.maze;

import fr.gwengwen49.mazeplugin.maze.chunks.MazeChunk;
import fr.gwengwen49.mazeplugin.util.Box;
import org.bukkit.Material;


public class Parameters
{
    public static Box wallMaxDimensions;

    public static Material[] wallMaterials;

    public static Material[] floorMaterials;

    public static short chunkSize;

    public static void setupDefaultConfig()
    {
        wallMaxDimensions = new Box(8, 45, 8);
        wallMaterials = new Material[]{Material.STONE, Material.STONE_BRICKS, Material.MOSSY_STONE_BRICKS, Material.MOSSY_COBBLESTONE};
        floorMaterials = new Material[]{Material.STONE, Material.STONE, Material.STONE_BRICKS, Material.STONE_BRICKS, Material.MOSSY_STONE_BRICKS, Material.MOSSY_STONE_BRICKS, Material.POLISHED_ANDESITE, Material.GRASS_BLOCK, Material.ANDESITE};
        chunkSize = 16;

    }






}