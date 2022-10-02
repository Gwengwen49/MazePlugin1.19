package fr.gwengwen49.mazeplugin.maze;



import fr.gwengwen49.mazeplugin.MazePlugin;
import fr.gwengwen49.mazeplugin.accessing.InjectionHandler;
import fr.gwengwen49.mazeplugin.maze.tasks.MazeTask;
import org.bukkit.Bukkit;
import org.bukkit.Location;


public class Maze{
    public static Maze INSTANCE;
    public final int taskID;
    private static MazeTask mazeTask;
        public Maze(Location startPos) {
            startPos = startPos;
            INSTANCE = this;
            mazeTask = new MazeTask(startPos);
            taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(MazePlugin.INSTANCE, mazeTask, 1, 2*20);
            InjectionHandler.getAndExecute(this.getClass(), "");
        }

    public int getTaskID() {
        return taskID;
    }

    public static MazeTask getMazeTask() {
        return mazeTask;
    }
    //((chunkCoord/16)+1)+"/"+(numbChunks*numbChunks)
        }




