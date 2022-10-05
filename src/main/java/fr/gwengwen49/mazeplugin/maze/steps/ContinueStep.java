package fr.gwengwen49.mazeplugin.maze.steps;

import fr.gwengwen49.mazeplugin.commands.SummoningCommand;
import fr.gwengwen49.mazeplugin.maze.registry.MazeRegistry;
import fr.gwengwen49.mazeplugin.maze.parts.Tickable;
import org.bukkit.Location;

public class ContinueStep extends GenStep{

 private Location startPos;
 public ContinueStep(Location startPos)
 {
 super(startPos, ContinueStep.class);
 }

 @Override
 public void run()
 {
  for(Object part : MazeRegistry.PARTS.getRegisterables())
  {
   if(part instanceof Tickable)
   {
    if(((Tickable)part).getTask() == this)
    ((Tickable)part).tick(this.startPos, SummoningCommand.getPlayer());
   }
  }
 }

 @Override
 public boolean isInfinite() {
  return true;
 }
}
