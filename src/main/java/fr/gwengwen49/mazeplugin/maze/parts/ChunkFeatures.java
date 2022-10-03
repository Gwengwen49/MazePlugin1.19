package fr.gwengwen49.mazeplugin.maze.parts;

import fr.gwengwen49.mazeplugin.maze.ChunkFeature;
import fr.gwengwen49.mazeplugin.maze.chunks.MazeChunk;
import fr.gwengwen49.mazeplugin.maze.parts.decorations.MazeDecoration;
import fr.gwengwen49.mazeplugin.maze.parts.decorations.SimpleBlockMazeDecoration;
import fr.gwengwen49.mazeplugin.maze.parts.pieces.Floor;
import fr.gwengwen49.mazeplugin.maze.parts.pieces.wall.Wall;
import org.bukkit.Material;
import org.bukkit.plugin.PluginLoader;

public class ChunkFeatures {

    public static ChunkFeature<Floor> FLOOR_CHUNK_FEATURE;
    public static ChunkFeature<Wall> WALL_CHUNK_FEATURE;
    public static ChunkFeature<SimpleBlockMazeDecoration> COBWEB_CHUNK_FEATURE;

    static {
        FLOOR_CHUNK_FEATURE = new ChunkFeature<>(new Floor(Material.STONE, Material.STONE, Material.STONE_BRICKS, Material.STONE_BRICKS, Material.MOSSY_STONE_BRICKS, Material.MOSSY_STONE_BRICKS, Material.POLISHED_ANDESITE, Material.GRASS_BLOCK, Material.ANDESITE), 1, 0);
        WALL_CHUNK_FEATURE = new ChunkFeature<>(new Wall(Direction.RANDOM), 22, 2);
        COBWEB_CHUNK_FEATURE = new ChunkFeature<>(new SimpleBlockMazeDecoration(MazeDecoration.Type.FLOOR, Material.COBWEB), 10, 0);


    }

    public static void register()
    {
        MazeChunk.add(FLOOR_CHUNK_FEATURE)
                .add(WALL_CHUNK_FEATURE)
                 .add(COBWEB_CHUNK_FEATURE);

    }

}
