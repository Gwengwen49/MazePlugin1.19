package fr.gwengwen49.mazeplugin.maze.chunks;
import fr.gwengwen49.mazeplugin.maze.ChunkFeature;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;


public class MazeChunk {

    public static MazeChunk INSTANCE;
    public static List<ChunkFeature> CHUNK_FEATURES = new ArrayList<>();

    private static Location startPos;
    public MazeChunk(Location startPos)
    {
        startPos = startPos;
        INSTANCE = this;
        for (ChunkFeature chunkFeature : CHUNK_FEATURES)
        {
            chunkFeature.build(startPos);
        }
    }

    public MazeChunk()
    {

    }

    public static Location getStartPos() {
        return startPos;
    }

    public static <T extends ChunkFeature> MazeChunk add(T feature)
    {
            CHUNK_FEATURES.add(feature);
            return INSTANCE;
    }


}