package fr.gwengwen49.mazeplugin.maze.steps;

import com.sun.source.tree.Tree;
import com.sun.source.tree.WhileLoopTree;
import fr.gwengwen49.mazeplugin.MazePlugin;
import fr.gwengwen49.mazeplugin.maze.registry.MazeRegistry;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class StepManager
{
    public static void launch() {

        Steps.FLOOR_STEP.runTaskTimer(MazePlugin.INSTANCE, 1, 2 * 20);
        Steps.WALL_STEP.runTaskTimer(MazePlugin.INSTANCE, 1, 2 * 20);
        Steps.DECORATION_STEP.runTaskTimer(MazePlugin.INSTANCE, 1, 2 * 20);

    }
}
