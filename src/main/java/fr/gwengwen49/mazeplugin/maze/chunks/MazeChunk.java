package fr.gwengwen49.mazeplugin.maze.chunks;
import fr.gwengwen49.mazeplugin.maze.ChunkFeature;
import fr.gwengwen49.mazeplugin.maze.registry.MazeRegistry;
import fr.gwengwen49.mazeplugin.maze.steps.GenStep;
import fr.gwengwen49.mazeplugin.maze.steps.GenerateAt;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;


public class MazeChunk {

    public static MazeChunk INSTANCE;
    private int radius;
    private int startX;
    private int startZ;
    public MazeChunk()
    {
        this.radius = radius;
        INSTANCE = this;
           }

           public MazeChunk build(Location startPos, Class<? extends GenStep> genStep) {
               MazeRegistry.CHUNK_FEATURES.getRegisterables().second().stream().filter(chunkFeature -> chunkFeature.genStep().equals(genStep)).forEach(chunkFeature -> chunkFeature.build(startPos));
               this.startX = startPos.getBlockX();
               this.startZ = startPos.getBlockZ();
               return this;
            }
    public int getRadius() {
        return radius;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartZ() {
        return startZ;
    }
}