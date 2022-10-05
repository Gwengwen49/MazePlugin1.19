package fr.gwengwen49.mazeplugin.maze.chunks;
import fr.gwengwen49.mazeplugin.maze.ChunkFeature;
import fr.gwengwen49.mazeplugin.maze.steps.GenStep;
import fr.gwengwen49.mazeplugin.maze.steps.GenerateAt;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;


public class MazeChunk {

    public static MazeChunk INSTANCE;
    public static List<ChunkFeature> CHUNK_FEATURES = new ArrayList<>();
    private int radius;
    private static Location startPos;
    public MazeChunk(Location startPos, Class<? extends GenStep> genStep)
    {
        startPos = startPos;
        this.radius = radius;
        INSTANCE = this;
        for (ChunkFeature chunkFeature : CHUNK_FEATURES)
        {
            if(chunkFeature.genStep() == genStep) {
                chunkFeature.build(startPos);
            }
        }
    }

    public MazeChunk()
    {

    }

    public int getRadius() {
        return radius;
    }

    public static Location getStartPos() {
        return startPos;
    }

    public static <T extends ChunkFeature> MazeChunk add(T... features)
    {
        for(ChunkFeature<?> feature : features)
        {
            CHUNK_FEATURES.add(feature);
        }
            return INSTANCE;

    }


}