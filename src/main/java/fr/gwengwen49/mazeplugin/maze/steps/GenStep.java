package fr.gwengwen49.mazeplugin.maze.steps;

import fr.gwengwen49.mazeplugin.commands.SummoningCommand;
import fr.gwengwen49.mazeplugin.maze.Maze;
import fr.gwengwen49.mazeplugin.maze.chunks.MazeChunk;
import fr.gwengwen49.mazeplugin.maze.registry.MazeRegistry;
import fr.gwengwen49.mazeplugin.maze.parts.Tickable;
import fr.gwengwen49.mazeplugin.maze.registry.RegistryEntry;
import fr.gwengwen49.mazeplugin.util.HelpFunctions;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public abstract class GenStep implements Runnable, RegistryEntry {

    private final Location startPos;
    private final Class<? extends GenStep> genStep;
    private int numbChunks = 16;
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
    @Override
    public void run() {

        int x = (int) startPos.getX();
        int y = (int) startPos.getY();
        int z = (int) startPos.getZ();
        Location loc = new Location(startPos.getWorld(), x+line, y, z+column);
        new MazeChunk(loc, genStep);
        Bukkit.broadcastMessage(HelpFunctions.convertToPercentage((float) numbChunks*numbChunks, (float) nbChunk)+"%"+"("+getChunkCoord()+")");
        for(Object part : MazeRegistry.PARTS.getRegisterables())
        {
            if(part instanceof Tickable)
            {
                if (((Tickable)part).getTask() == this)
                {
                    ((Tickable)part).tick(loc, SummoningCommand.getPlayer());
                }
            }
        }
        line = line+16;
        nbChunk++;
        chunkCoord = chunkCoord+16;
        if(line == 16*numbChunks)
        {
            column = column+16;
            line = 0;
        }
        if(column == 16*numbChunks)
        {
            if(this.isInfinite() == false) {
                this.isFinished = true;
                Bukkit.getScheduler().cancelTask(Maze.getInstance().getTaskID());
            }
            else {
                line = 0;
                column = 0;
            }
        }

    }

    public abstract boolean isInfinite();
    public Class<? extends GenStep> getGenStep() {
        return genStep;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public int getChunkCoord() {
        return (chunkCoord/16)+1;
    }
}