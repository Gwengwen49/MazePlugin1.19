package fr.gwengwen49.mazeplugin.commands;

import fr.gwengwen49.mazeplugin.maze.Maze;
import fr.gwengwen49.mazeplugin.maze.parts.ChunkFeatures;
import fr.gwengwen49.mazeplugin.util.Constants;
import org.bukkit.Bukkit;
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
                startPos = ((Player) sender).getLocation();
                maze = new Maze();
                maze.build(startPos);
                return true;
            }
            for (String arg : args) {

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
