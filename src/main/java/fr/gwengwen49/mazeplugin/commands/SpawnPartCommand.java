package fr.gwengwen49.mazeplugin.commands;

import fr.gwengwen49.mazeplugin.maze.parts.Part;
import fr.gwengwen49.mazeplugin.maze.registry.MazeRegistry;
import fr.gwengwen49.mazeplugin.util.Constants;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnPartCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Object part;
        for(String arg : args) {
            if (arg.contains(MazeRegistry.PARTS.getTypeName()+"/")) {
                part = MazeRegistry.PARTS.getFromName(arg);
                if (part instanceof Part) {
                    ((Part) part).generate(((Player) sender).getLocation());
                }
            }
        }
        return true;
    }
}
