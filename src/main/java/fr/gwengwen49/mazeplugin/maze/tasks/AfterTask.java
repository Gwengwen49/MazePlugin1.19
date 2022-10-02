package fr.gwengwen49.mazeplugin.maze.tasks;

import fr.gwengwen49.mazeplugin.commands.SpawnPartCommand;
import fr.gwengwen49.mazeplugin.commands.SummoningCommand;
import fr.gwengwen49.mazeplugin.maze.parts.Part;
import fr.gwengwen49.mazeplugin.maze.parts.PartsRegistry;
import fr.gwengwen49.mazeplugin.maze.parts.Tickable;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

public class AfterTask implements Runnable{

 private Location startPos;
 public AfterTask(Location startPos)
 {
this.startPos = startPos;
 }

 @Override
 public void run()
 {
  for(Part part : PartsRegistry.getParts())
  {
   if(part instanceof Tickable)
   {
    if(((Tickable)part).getTask() == this)
    ((Tickable)part).tick(this.startPos, SummoningCommand.getPlayer());
   }
  }
 }
}
