package fr.gwengwen49.mazeplugin.commands;

import fr.gwengwen49.mazeplugin.maze.Maze;
import fr.gwengwen49.mazeplugin.maze.Parameters;
import fr.gwengwen49.mazeplugin.maze.registry.MazeRegistry;
import fr.gwengwen49.mazeplugin.util.Constants;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SummoningCommand implements CommandExecutor {

    private static Location startPos;
    private static Player player;
    private static Maze maze;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            player = (Player) sender;
            if(args[0].equals("simple")) {
                Parameters.setupDefaultConfig();
                startPos = ((Player) sender).getLocation();
                new Maze(startPos);

                Constants.init();
                return true;
            }

        }

            return true;
    }

    public static Player getPlayer() {
        return player;
    }

    public static Location getStartPos()
    {
        return startPos;
    }

    public static Maze getMaze() {
        return maze;
    }
}
