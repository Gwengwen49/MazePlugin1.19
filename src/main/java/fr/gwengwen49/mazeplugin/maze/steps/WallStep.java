package fr.gwengwen49.mazeplugin.maze.steps;

import org.bukkit.Location;

public class WallStep extends GenStep
{

    public WallStep(Location startPos) {
        super(startPos, WallStep.class);
    }

    @Override
    public boolean isInfinite() {
        return false;
    }
}
