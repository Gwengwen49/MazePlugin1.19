package fr.gwengwen49.mazeplugin.maze;



import fr.gwengwen49.mazeplugin.MazePlugin;
import fr.gwengwen49.mazeplugin.maze.steps.GenStep;
import fr.gwengwen49.mazeplugin.maze.steps.StepManager;
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
            StepManager.launch();
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






