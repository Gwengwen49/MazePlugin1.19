package fr.gwengwen49.mazeplugin.maze.steps;


import org.bukkit.Location;

public class ContinueStep extends GenStep{

 private Location startPos;
 public ContinueStep(Location startPos)
 {
 super(startPos, ContinueStep.class);
 }

 @Override
 public boolean isInfinite() {
  return true;
 }
}
