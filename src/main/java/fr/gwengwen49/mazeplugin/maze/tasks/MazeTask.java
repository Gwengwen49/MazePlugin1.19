package fr.gwengwen49.mazeplugin.maze.tasks;

import fr.gwengwen49.mazeplugin.commands.SummoningCommand;
import fr.gwengwen49.mazeplugin.maze.Maze;
import fr.gwengwen49.mazeplugin.maze.chunks.MazeChunk;
import fr.gwengwen49.mazeplugin.maze.parts.Part;
import fr.gwengwen49.mazeplugin.maze.registry.MazeRegistry;
import fr.gwengwen49.mazeplugin.maze.registry.PartsRegistry;
import fr.gwengwen49.mazeplugin.maze.parts.Tickable;
import fr.gwengwen49.mazeplugin.maze.registry.RegistryEntry;
import fr.gwengwen49.mazeplugin.util.HelpFunctions;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class MazeTask implements Runnable {

    private final Location startPos;
    private int numbChunks = 16;
    private int line = 0;
    private int nbChunk = 1;
    private int column = 0;
    private int chunkCoord;
    private boolean isFinished;
    public MazeTask(Location startPos)
    {
        this.startPos = startPos;
    }
    @Override
    public void run() {

        int x = (int) startPos.getX();
        int y = (int) startPos.getY();
        int z = (int) startPos.getZ();
        Location loc = new Location(startPos.getWorld(), x+line, y, z+column);
        new MazeChunk(loc);
        Bukkit.broadcastMessage(HelpFunctions.convertToPercentage((float) numbChunks*numbChunks, (float) nbChunk)+"%"+"("+getChunkCoord()+")");
        for(Object part : MazeRegistry.getInstance().getRegisterables())
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
            this.isFinished = true;

            Bukkit.getScheduler().cancelTask(Maze.getInstance().getTaskID());
        }

    }

    public boolean isFinished() {
        return isFinished;
    }

    public int getChunkCoord() {
        return (chunkCoord/16)+1;
    }
}
