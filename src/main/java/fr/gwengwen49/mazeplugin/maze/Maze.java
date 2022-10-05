package fr.gwengwen49.mazeplugin.maze;



import fr.gwengwen49.mazeplugin.MazePlugin;
import fr.gwengwen49.mazeplugin.maze.steps.GenStep;
import org.bukkit.Bukkit;
import org.bukkit.Location;


public class Maze{
    private static Maze INSTANCE;
    private int taskID;
    private static GenStep genStep;
    private Location startPos;
        public Maze(Location startPos) {
            INSTANCE = this;
            this.startPos = startPos;
            taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(MazePlugin.INSTANCE, genStep, 1, 2*20);

        }
    public Location getStartPos() {
        return startPos;
    }

    public int getTaskID() {
        return taskID;
    }

    public static GenStep getMazeTask() {
        return genStep;
    }

    public static Maze getInstance() {
        return INSTANCE;
    }

    //((chunkCoord/16)+1)+"/"+(numbChunks*numbChunks)
        }






