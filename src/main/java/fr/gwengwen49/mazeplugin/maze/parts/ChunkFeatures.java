package fr.gwengwen49.mazeplugin.maze.parts;

import fr.gwengwen49.mazeplugin.maze.ChunkFeature;
import fr.gwengwen49.mazeplugin.maze.chunks.MazeChunk;
import fr.gwengwen49.mazeplugin.maze.parts.decorations.MazeDecoration;
import fr.gwengwen49.mazeplugin.maze.parts.decorations.SimpleBlockMazeDecoration;
import fr.gwengwen49.mazeplugin.maze.parts.decorations.TreeDecoration;
import fr.gwengwen49.mazeplugin.maze.parts.pieces.Floor;
import fr.gwengwen49.mazeplugin.maze.parts.pieces.wall.Wall;
import fr.gwengwen49.mazeplugin.maze.steps.DecorationStep;
import fr.gwengwen49.mazeplugin.maze.steps.FloorStep;
import fr.gwengwen49.mazeplugin.maze.steps.GenerateAt;
import fr.gwengwen49.mazeplugin.maze.steps.WallStep;
import org.bukkit.Material;

import java.util.Optional;

public class ChunkFeatures {

    public static ChunkFeature<Floor> FLOOR_CHUNK_FEATURE;
    public static ChunkFeature<Wall> WALL_CHUNK_FEATURE;
    public static ChunkFeature<SimpleBlockMazeDecoration> COBWEB_CHUNK_FEATURE;
    public static ChunkFeature<TreeDecoration> TREE_FEATURES;

    static {
        FLOOR_CHUNK_FEATURE = new ChunkFeature<>(new Floor(Material.STONE, Material.STONE, Material.STONE_BRICKS, Material.STONE_BRICKS, Material.MOSSY_STONE_BRICKS, Material.MOSSY_STONE_BRICKS, Material.POLISHED_ANDESITE, Material.GRASS_BLOCK, Material.ANDESITE), FloorStep.class, 1, 0);
        WALL_CHUNK_FEATURE = new ChunkFeature<>(new Wall(Direction.RANDOM), WallStep.class, 22, 2);
        COBWEB_CHUNK_FEATURE = new ChunkFeature<>(new SimpleBlockMazeDecoration(MazeDecoration.Type.FLOOR, Material.COBWEB), DecorationStep.class, 10, 0);
        TREE_FEATURES = new ChunkFeature<>(new TreeDecoration(MazeDecoration.Type.FLOOR, Material.OAK_LEAVES, 3, Material.OAK_LOG, 6), DecorationStep.class, 10, 2);

    }

    public static void register()
    {
        MazeChunk.add(
                FLOOR_CHUNK_FEATURE,
                WALL_CHUNK_FEATURE,
                COBWEB_CHUNK_FEATURE,
                TREE_FEATURES
        );

    }

}
