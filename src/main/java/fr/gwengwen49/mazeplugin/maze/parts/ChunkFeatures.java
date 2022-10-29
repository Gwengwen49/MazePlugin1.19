package fr.gwengwen49.mazeplugin.maze.parts;

import fr.gwengwen49.mazeplugin.maze.ChunkFeature;
import fr.gwengwen49.mazeplugin.maze.chunks.MazeChunk;
import fr.gwengwen49.mazeplugin.maze.parts.decorations.MazeDecoration;
import fr.gwengwen49.mazeplugin.maze.parts.decorations.SimpleBlockMazeDecoration;
import fr.gwengwen49.mazeplugin.maze.parts.decorations.TreeDecoration;
import fr.gwengwen49.mazeplugin.maze.parts.pieces.Floor;
import fr.gwengwen49.mazeplugin.maze.parts.pieces.wall.Wall;
import fr.gwengwen49.mazeplugin.maze.registry.MazeRegistry;
import fr.gwengwen49.mazeplugin.maze.steps.DecorationStep;
import fr.gwengwen49.mazeplugin.maze.steps.FloorStep;
import fr.gwengwen49.mazeplugin.maze.steps.GenerateAt;
import fr.gwengwen49.mazeplugin.maze.steps.WallStep;
import org.bukkit.Material;

import java.util.Optional;

public class ChunkFeatures {

    public static ChunkFeature<Floor> FLOOR_CHUNK_FEATURE;
    public static ChunkFeature<Wall> WALL_CHUNK_FEATURE;
    public static ChunkFeature<Wall> SMALL_WALL_CHUNK_FEATURE;
    public static ChunkFeature<SimpleBlockMazeDecoration> COBWEB_CHUNK_FEATURE;
    public static ChunkFeature<TreeDecoration> TREE_FEATURE;

    static {
        FLOOR_CHUNK_FEATURE = new ChunkFeature<>(Parts.FLOOR, FloorStep.class, 1, 0);
        WALL_CHUNK_FEATURE = new ChunkFeature<>(Parts.WALL, WallStep.class, 22, 2);
        //SMALL_WALL_CHUNK_FEATURE = new ChunkFeature<>(Parts.SMALL_WALL, WallStep.class, 22, 2);
        COBWEB_CHUNK_FEATURE = new ChunkFeature<>(Parts.COBWEB, DecorationStep.class, 10, 0);
        TREE_FEATURE = new ChunkFeature<>(Parts.TREE, DecorationStep.class, 10, 2);

    }
    public static void register()
    {
        MazeRegistry.CHUNK_FEATURES
                .register(FLOOR_CHUNK_FEATURE, "floor")
                .register(WALL_CHUNK_FEATURE, "wall")
                .register(COBWEB_CHUNK_FEATURE, "cobweb")
                .register(TREE_FEATURE, "tree");
    }

}
