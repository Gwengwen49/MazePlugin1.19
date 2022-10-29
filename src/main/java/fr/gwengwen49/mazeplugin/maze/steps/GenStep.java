package fr.gwengwen49.mazeplugin.maze.steps;

import fr.gwengwen49.mazeplugin.commands.SummoningCommand;
import fr.gwengwen49.mazeplugin.maze.Parameters;
import fr.gwengwen49.mazeplugin.maze.chunks.MazeChunk;
import fr.gwengwen49.mazeplugin.maze.registry.MazeRegistry;
import fr.gwengwen49.mazeplugin.maze.parts.Tickable;
import fr.gwengwen49.mazeplugin.maze.registry.RegistryEntry;
import fr.gwengwen49.mazeplugin.util.Functions;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;

public abstract class GenStep extends BukkitRunnable implements RegistryEntry {

    private final Location startPos;
    private final Class<? extends GenStep> genStep;
    private static MazeChunk chunk;
    private int numbChunks = 40;
    private int line = 0;
    private int nbChunk = 1;
    private int column = 0;
    private int chunkCoord;
    private boolean isFinished;
    public GenStep(Location startPos, Class<? extends GenStep> genStep)
    {
        this.startPos = startPos;
        this.genStep = genStep;
    }

    public GenStep(Class<? extends GenStep> genStep)
    {
        this(SummoningCommand.getStartPos(), genStep);
    }
    @Override
    public void run() {

        int x = (int) startPos.getX();
        int y = (int) startPos.getY();
        int z = (int) startPos.getZ();
        Location loc = new Location(startPos.getWorld(), x+line, y, z+column);
        chunk = new MazeChunk();
        chunk.build(loc, genStep);
        Bukkit.broadcastMessage(Functions.convertToPercentage((float) numbChunks*numbChunks, (float) nbChunk)+"%"+"("+getChunkCoord()+")");
        MazeRegistry.PARTS.getRegisterables().second().stream().forEach(part -> {
            if(part instanceof Tickable) {
                if (((Tickable)part).getTask().getClass().equals(this.genStep)) {
                    ((Tickable)part).tick(loc, SummoningCommand.getPlayer());
                }
            }
        });


        line = line + Parameters.chunkSize;
        nbChunk++;
        chunkCoord = chunkCoord + Parameters.chunkSize;
        if(line == Parameters.chunkSize*numbChunks)
        {
            column = column+ Parameters.chunkSize;
            line = 0;
        }
        if(column == Parameters.chunkSize*numbChunks)
        {
            if(isInfinite() == true)
            {
                line = 0;
                column = 0;
            }
            else if(isInfinite() == false) {
                isFinished = true;
                this.cancel();
            }
        }
    }


    public abstract boolean isInfinite();

    public synchronized boolean isFinished() {
        return isFinished;
    }

    public int getChunkCoord() {
        return (chunkCoord/16)+1;
    }
}
