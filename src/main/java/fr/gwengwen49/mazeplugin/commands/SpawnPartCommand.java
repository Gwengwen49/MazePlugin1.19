package fr.gwengwen49.mazeplugin.commands;

import fr.gwengwen49.mazeplugin.maze.Maze;
import fr.gwengwen49.mazeplugin.maze.parts.Part;
import fr.gwengwen49.mazeplugin.maze.parts.PartsRegistry;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnPartCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Part part;
        for(String arg : args)
        {
           part = PartsRegistry.getPartFromName(arg);
           part.generate(((Player)sender).getLocation());
        }
        return true;
    }
}
