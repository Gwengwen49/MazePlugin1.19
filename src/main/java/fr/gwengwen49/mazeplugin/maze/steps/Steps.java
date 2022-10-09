package fr.gwengwen49.mazeplugin.maze.steps;

import fr.gwengwen49.mazeplugin.commands.SummoningCommand;
import fr.gwengwen49.mazeplugin.maze.registry.MazeRegistry;
import fr.gwengwen49.mazeplugin.util.Identity;
import org.bukkit.Location;



public class Steps {
    private static Location sp = SummoningCommand.getStartPos();
    public static GenStep FLOOR_STEP;
    public static GenStep WALL_STEP;
    public static GenStep DECORATION_STEP;
    public static GenStep CONTINUE_STEP;

        static
        {
        FLOOR_STEP = new FloorStep(sp);
        WALL_STEP = new WallStep(sp);
        DECORATION_STEP = new DecorationStep(sp);
        CONTINUE_STEP = new ContinueStep(sp);

        }

    public static void register()
    {
        MazeRegistry.STEPS
                .register(FLOOR_STEP, "floor")
                .register(WALL_STEP, "wall")
                .register(DECORATION_STEP, "decoration")
                .register(CONTINUE_STEP, "after");
    }


}
