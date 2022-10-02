package fr.gwengwen49.mazeplugin.maze.tasks;

import fr.gwengwen49.mazeplugin.commands.SummoningCommand;
import fr.gwengwen49.mazeplugin.maze.parts.Part;
import fr.gwengwen49.mazeplugin.maze.registry.MazeRegistry;
import fr.gwengwen49.mazeplugin.maze.registry.PartsRegistry;
import fr.gwengwen49.mazeplugin.maze.parts.Tickable;
import org.bukkit.Location;

public class AfterTask implements Runnable{

 private Location startPos;
 public AfterTask(Location startPos)
 {
this.startPos = startPos;
 }

 @Override
 public void run()
 {
  for(Object part : MazeRegistry.getInstance().getRegisterables())
  {
   if(part instanceof Tickable)
   {
    if(((Tickable)part).getTask() == this)
    ((Tickable)part).tick(this.startPos, SummoningCommand.getPlayer());
   }
  }
 }
}
