package fr.gwengwen49.mazeplugin.maze;



import fr.gwengwen49.mazeplugin.MazePlugin;
import fr.gwengwen49.mazeplugin.accessing.InjectionHandler;
import fr.gwengwen49.mazeplugin.maze.tasks.MazeTask;
import org.bukkit.Bukkit;
import org.bukkit.Location;


public class Maze{
    private static Maze INSTANCE;
    private int taskID;
    private static MazeTask mazeTask;
    private Location startPos;
        public Maze() {
            INSTANCE = this;
            mazeTask = new MazeTask(startPos);
        }
        public Maze build(Location startPos){
            this.startPos = startPos;
            taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(MazePlugin.INSTANCE, mazeTask, 1, 2*20);
            return this;
        }
    public Location getStartPos() {
        return startPos;
    }

    public int getTaskID() {
        return taskID;
    }

    public static MazeTask getMazeTask() {
        return mazeTask;
    }

    public static Maze getInstance() {
        return INSTANCE;
    }

    //((chunkCoord/16)+1)+"/"+(numbChunks*numbChunks)
        }






